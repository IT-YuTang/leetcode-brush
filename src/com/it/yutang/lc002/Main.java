package com.it.yutang.lc002;

/**
 * @Author: 渔◕‿◕堂
 * @Description: 两数相加
 * @Date: 2018/12/13
 */
public class Main {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode header = new ListNode(0);//表头
        ListNode curNode = header;

        //进位
        int carry = 0;
        while (node1 != null || node2 != null) {
            int node1Val = node1 == null ? 0 : node1.val;
            int node2Val = node2 == null ? 0 : node2.val;

            //当前节点值
            int sum = carry + node1Val + node2Val;
            //是否进位
            carry = sum / 10;

            //新节点一位表示
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;

            if (node1 != null)
                node1 = node1.next;
            if (node2 != null)
                node2 = node2.next;
        }

        if (carry > 0){
            curNode.next = new ListNode(carry);
        }

        return header.next;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
