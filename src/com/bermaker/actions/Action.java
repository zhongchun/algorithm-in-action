/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.actions;

/**
 * @ClassName: Action
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/6 8:50 PM
 * @Version: 1.0
 */
interface Action {
    public String getType();

    public long getTimestamp();

    public String getInfo();
}
