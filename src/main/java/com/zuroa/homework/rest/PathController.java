package com.zuroa.homework.rest;

import com.zuroa.homework.model.entity.User;
import com.zuroa.homework.service.TopNPopularPathService;
import com.zuroa.homework.util.LinkedNodes;
import com.zuroa.homework.log.LogFileUtil;
import com.zuroa.homework.util.PageNode;
import com.zuroa.homework.util.ThreePath;
import com.zuroa.homework.util.ValueComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Stream;

@RestController
public class PathController {

    @Autowired
    TopNPopularPathService topNPopularPathService;

    @RequestMapping("/paths")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/paths/topn/{n}", method = {RequestMethod.GET})
    public ResponseEntity<String[]> getTopNPaths(@PathVariable("n") int n) {
        String[] topNPopularPaths = topNPopularPathService.getTopNPopularPaths(n);
        return new ResponseEntity<String[]>(topNPopularPaths, HttpStatus.OK);
    }

}