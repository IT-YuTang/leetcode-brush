package com.it.yutang.lc004;

import java.util.Arrays;

/**
 * @Author: 渔◕‿◕堂
 * @Description: 寻找两个有序数组的中位数
 * @Date: 2018/12/17
 */
class Main {
    public static void main(String[] args) {

        int[] nums1 = { -1, -2 };
        int[] nums2 = { 3 };

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double result;

        //连接两个数组
        int[] nums = concat(nums1, nums2);
        //新数组从低到高排序
        Arrays.sort(nums);

        //判断数组长度是奇偶数
        int even = nums.length % 2;
        if (even == 0) { //偶数位，中间两位求和除以2
            result = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        }
        else {
            //取中间位的元素
            result = nums[nums.length / 2];
        }

        return result;
    }

    /** 连接两个数组
     * @param a
     * @param b
     * @return
     */
    static int[] concat(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }
}
