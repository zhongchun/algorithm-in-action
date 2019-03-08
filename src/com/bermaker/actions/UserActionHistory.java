/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.bermaker.actions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName: UserActionHistory
 * @Project: algorithm-in-action
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019/3/6 8:52 PM
 * @Version: 1.0
 */
public class UserActionHistory implements ActionHistory {

    private Map<String, List<Action>> histories;

    public static Comparator<Action> idComparator = new Comparator<Action>() {
        public int compare(Action a1, Action a2) {
            if (a1.getTimestamp() > a2.getTimestamp()) {
                return 1;
            } else if (a1.getTimestamp() == a2.getTimestamp()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public UserActionHistory() {
        histories = new HashMap<>();
    }

    public void addNewAction(Action action) {
        if (action != null) {
            if (!histories.containsKey(action.getType())) {
                List<Action> list = new ArrayList<>();
                list.add(action);
                histories.put(action.getType(), list);
            } else {
                histories.get(action.getType()).add(action);
            }
        }
    }

    public List<Action> getRecentActions(int n) {
        List<Action> list = new ArrayList<>();
        Queue<Action> maxQueue = new PriorityQueue<>(idComparator);
        Set<String> types = histories.keySet();
        Map<String, Integer> map = new HashMap<>();
        for (String type : types) {
            List<Action> tmpList = histories.get(type);
            maxQueue.add(tmpList.get(tmpList.size() - 1));
            map.put(type, 1);
        }
        for (int i = 0; i < n; i++) {
            Action action = maxQueue.poll();
            if (action != null) {
                list.add(action);
                int pos = map.get(action.getType());
                List<Action> l = histories.get(action.getType());
                int index = l.size() - 1 - pos;
                if (index >= 0) {
                    Action tmpAction = l.get(index);
                    maxQueue.add(tmpAction);
                }
                map.put(action.getType(), pos + 1);
                list.add(action);
            } else {
                break;
            }
        }
        return list;
    }

    public List<Action> getRecentActions(String type, int n) {
        List<Action> list = new ArrayList<>();
        List<Action> typeList = histories.get(type);
        if (typeList != null) {
            for (int i = typeList.size() - 1; (i >= 0 && n >= 0); i++) {
                list.add(typeList.get(i));
                n--;
            }
        }
        return list;
    }
}
