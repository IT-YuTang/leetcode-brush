[中文原题](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)
#### 无重复字符的最长子串
> 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1：
```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```
示例 2：
```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```
示例 3：
```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

#### 原题解析
1. 字符串需要遍历，查找不重复的子串；
2. 长度需要通过字符下标相减；
3. 既需要知道字符是否重复，又需要知道下标是多少，首选哈希；
4. 出现重复字符，被减数下标需要右移；同时需要判断子串中是否有重复字符；
 
##### 解法

1. 第一个不重复位置(**firstIndex**)默认从0开始，遍历字符串，不重复时，长度为下标相减同时加1；

2. 发遍历到重复字符时，需要之前的重复字符位置加1，向右移动；

3.依此类推，遍历到重复字符需要右移；

4.需要注意的是，如果两个重复字符中间还有其它重复字符时，需要取大的下标作为不重复位置继续遍历；



###### 解题代码
```
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
```

###### 复杂度分析
    * 时间复杂度：O(n),遍历一次。
    * 空间复杂度：O(m),m取决于不重复字符数量。
