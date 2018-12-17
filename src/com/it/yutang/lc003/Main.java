package com.it.yutang.lc003;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 渔◕‿◕堂
 * @Description: 无重复字符的最长子串
 * @Date: 2018/12/14
 */
class Main {
    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";

        System.out.println(lengthOfLongestSubstring(str1));
        System.out.println(lengthOfLongestSubstring(str2));
        System.out.println(lengthOfLongestSubstring(str3));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int result = 0;
        int firstIndex = 0;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int index = 0; index < s.length(); index++) {
            char key = s.charAt(index);
            if (map.containsKey(key)){
                //默认为重复字符位置加1，其中可能包含其它重复子串，需要取大
                firstIndex = Math.max(map.get(key) + 1,firstIndex);
            }

            //计算长度
            result = Math.max(result,index - firstIndex + 1);
            map.put(key,index);
        }

        return result;
    }
}
