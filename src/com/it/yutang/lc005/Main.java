package com.it.yutang.lc005;

/**
 * @Author: 渔◕‿◕堂
 * @Description: 最长回文子串
 * @Date: 2018/12/18
 */
class Main {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcda"));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()){
            return "";
        }
        String result = s.charAt(0)+"";
        int maxLength = 0;
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            int nextIndex = s.lastIndexOf(ch+"");
            if (nextIndex != -1 && (nextIndex - index + 1) > maxLength){
                maxLength = nextIndex - index + 1;
                result  = s.substring(index,nextIndex+1);
            }
        }

        return result;
    }
}
