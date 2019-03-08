/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.test.algorithms;

import org.junit.Assert;
import org.junit.Test;

import com.bermaker.algorithms.twoeggs.Floor;

/**
 * @ClassName: FloorTest
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/8 3:45 PM
 * @Version: 1.0
 */
public class FloorTest {

    private Floor floor = new Floor();

    @Test
    public void testSuperEggDrop() {
        int leastNumber = floor.superEggDrop(2, 100);
        Assert.assertEquals(14, leastNumber);
    }

}
