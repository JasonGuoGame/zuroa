package com.zuroa.homework.log;

import com.zuroa.homework.model.entity.User;
import com.zuroa.homework.util.LinkedNode;
import com.zuroa.homework.util.LinkedNodes;
import com.zuroa.homework.util.PageNode;
import com.zuroa.homework.util.ThreePath;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by scnyig on 9/14/2017.
 */
public class LogFileUtil {
    //retrieve all rows from log file
    private final static String FILE_PATH = "LOG.txt";

    /*
    * parse the log file to user -> linkedlist into map
    * every row represent one node
     */
    public static Map<User, LinkedNodes> parseLog(List<PageNode> userNodes) {
        Map<User, LinkedNodes> userToPath = new HashMap<>();
        for (PageNode node : userNodes) {
            User user = node.getUser();
            String url = node.getUrl();
            if(userToPath.containsKey(user)) {
                LinkedNodes linkedList = userToPath.get(user);
                linkedList.add(url);
            }else {
                LinkedNode linkedNode = new LinkedNode(url);
                LinkedNodes paths = new LinkedNodes(linkedNode);
                userToPath.put(user,paths);
            }
        }
        return userToPath;
    }


    /**
     * loop all user's path to parse all three path object with map<threepath,num>
     * @param userPaths
     * @return
     */
    public static Map<ThreePath, Integer> parseToThreePathMap(Map<User, LinkedNodes> userPaths) {
        Iterator userIterator = userPaths.keySet().iterator();
        Map<ThreePath,Integer> threePathNumMap = new HashMap<ThreePath,Integer>();

        while (userIterator.hasNext()) {
            User user = (User) userIterator.next();
            LinkedNodes linkedNodes = userPaths.get(user);
            LinkedNode head = linkedNodes.getHead();
            LinkedNode current = head;
            while (current.next != null) {
                if(current.next.next != null) {
                    LinkedNodes pathNodes = new LinkedNodes(current);
                    pathNodes.add(current.next);
                    pathNodes.add(current.next.next);
                    ThreePath threePath = new ThreePath(pathNodes);
                    if(threePathNumMap.containsKey(threePath)) {
                        Integer integer = threePathNumMap.get(threePath);
                        threePathNumMap.put(threePath,integer + 1);
                    }else {
                        threePathNumMap.put(threePath,1);
                    }
                    current = current.next;
                } else {
                    break;
                }

            }
        }
        return threePathNumMap;
    }

    public static List<PageNode> getAllPageNodes() {
        List<PageNode> list = new ArrayList<>();

        try {
//            String utilPath = LogFileUtil.class.getResource("/").getFile().toString();
            RandomAccessFile aFile = new RandomAccessFile(FILE_PATH, "r");
            try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH), Charset.defaultCharset())) {
                lines.forEachOrdered(line -> {
                    String[] data = line.split(" ");
                    PageNode node = new PageNode(new User(data[0]),data[1]);
                    list.add(node);
                });
            }

            aFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
