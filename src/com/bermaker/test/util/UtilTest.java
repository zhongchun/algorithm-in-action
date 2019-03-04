/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;

/**
 * @ClassName: UtilTest
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/1 11:25 AM
 * @Version: 1.0
 */
public class UtilTest {

    private HashMap<String, String> hashMap;

    private ArrayList<String> arrayList;

    private LinkedList<String> linkedList;

    @Before
    public void init() {
        hashMap = new HashMap<>();
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
    }

}
