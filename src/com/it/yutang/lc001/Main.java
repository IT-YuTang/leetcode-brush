package com.it.yutang.lc001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 渔◕‿◕堂
 * @Description: 两数之和
 * @Date: 2018/12/13
 */
class Main {
    public static void main(String[] args) {

        int[] array = new int[] { 2, 7, 11, 15 };
        int target = 9;

        System.out.println(Arrays.toString(twoSum01(array, target)));
        System.out.println(Arrays.toString(twoSum02(array, target)));

    }

    /**
     * 两层循环遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        throw new IllegalArgumentException("Solution Not Found");
    }

    /**
     * 哈希表一次遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[] { map.get(result), i };
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("Solution Not Found");
    }
}
