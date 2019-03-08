/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.actions;

import java.util.List;

/**
 * @ClassName: ActionHistory
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/6 8:50 PM
 * @Version: 1.0
 */
interface ActionHistory {
    void addNewAction(Action action);

    public List<Action> getRecentActions(int n);

    public List<Action> getRecentActions(String type, int n);
}
