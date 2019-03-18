/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testString() {
        Byte[] bytes = new Byte[0];
        Assert.assertEquals(0, bytes.length);
    }

    @Test
    public void testInteger() {
        Integer a = 1000, b = 1000;
        System.out.println(a.intValue() == b.intValue());
        System.out.println(a == b);//1
        Integer c = 100, d = 100;
        System.out.println(c == d);//2
    }

    @Test
    public void testHashMap() {
        hashMap.put("name", "Atom");
        Assert.assertEquals(true, hashMap.containsKey("name"));
    }

    @Test
    public void testCollections() {
        Map<String, String> map = Collections.synchronizedMap(hashMap);
    }

    @Test
    public void testConcurrentHashMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
    }

    @Test
    public void testArray() {
        String[] strings = {"a", "b", "c"};
        List<String> list = Arrays.asList(strings);
        System.out.println(list.get(0)); // "a"
        strings[0] = "d";
        System.out.println(list.get(0)); // "d"
        list.set(0, "e");
        System.out.println(strings[0]); // "e"
    }

    @Test
    public void testQueue() {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    }

}
