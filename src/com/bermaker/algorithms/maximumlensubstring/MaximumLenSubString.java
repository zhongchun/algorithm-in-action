/**
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 * @Title: MaximumLenSubString.java
 * @Package: com.bermaker.algorithms.maximumlensubstring
 * @Desc: TODO
 * @author: yuzhongchun
 * @date: 2018年9月11日 下午4:27:49
 * @version 1.0
 */
package com.bermaker.algorithms.maximumlensubstring;

import java.util.HashMap;

/**
 * @ClassName: MaximumLenSubString
 * @Desc: TODO
 * @author: yuzhongchun
 * @date: 2018年9月11日 下午4:27:49
 * 
 */
public class MaximumLenSubString {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = new Character(s.charAt(i));
            if (!map.containsKey(c) || (map.get(c) < start)) {
                curLen++;
            } else {
                start = map.get(c) + 1;
                curLen = i - start + 1;
            }
            map.put(c, i);
            if (maxLen < curLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }

}
