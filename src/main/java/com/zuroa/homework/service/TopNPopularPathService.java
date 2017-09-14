package com.zuroa.homework.service;

import org.springframework.stereotype.Component;

/**
 * Created by scnyig on 9/6/2017.
 */

public interface TopNPopularPathService {
    void setup(String[][] data);
    String[] getTopNPopularPaths(int n);
}
