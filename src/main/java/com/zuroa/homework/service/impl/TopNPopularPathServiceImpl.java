package com.zuroa.homework.service.impl;

import com.zuroa.homework.log.LogFileUtil;
import com.zuroa.homework.model.entity.User;
import com.zuroa.homework.service.TopNPopularPathService;
import com.zuroa.homework.util.*;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by scnyig on 9/6/2017.
 */
@Component
public class TopNPopularPathServiceImpl implements TopNPopularPathService {
    @Override
    public void setup(String[][] data) {

    }

    @Override
    public String[] getTopNPopularPaths(int n) {
        //get top n three path from treemap
        String[] rtn = new String[n];
        List<PageNode> allPageNodes = LogFileUtil.getAllPageNodes();
        Map<User, LinkedNodes> userLinkedNodesMap = LogFileUtil.parseLog(allPageNodes);
        Map<ThreePath, Integer> threePathIntegerMap = LogFileUtil.parseToThreePathMap(userLinkedNodesMap);

        ValueComparator bvc = new ValueComparator(threePathIntegerMap);
        TreeMap<ThreePath, Integer> sorted_map = new TreeMap<ThreePath, Integer>(bvc);
        sorted_map.putAll(threePathIntegerMap);
        Iterator<ThreePath> iterator = sorted_map.keySet().iterator();
        int size = sorted_map.size();
        int min = n < size? n : size;
        for (int i = 0;i < min; i++) {
            ThreePath next = iterator.next();
            rtn[i] = next.toString();
        }

        return rtn;
    }
}
