package com.it.yutang.lc203;

/**
 * @Author: 渔◕‿◕堂
 * @Description:
 * @Date: 2018/12/27
 */
class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty.");
        }

        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode curNode = this;

        while (curNode != null){
            builder.append(curNode.val + "->");
            curNode = curNode.next;
        }

        builder.append("NULL");

        return builder.toString();
    }
}
