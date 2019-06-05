package com.it.yutang.lc203;

import javafx.scene.shape.VLineTo;

/**
 * @Author: 渔◕‿◕堂
 * @Description:
 * @Date: 2018/12/27
 */
class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 3, 4, 5, 6 };
        int[] arr2 = { 6 };

        System.out.println(removeElements(new ListNode(arr), 6));
        System.out.println(removeElements2(new ListNode(arr2), 6));

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }
            else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

//        ListNode res = removeElements2(head.next, val);
//        if (head.val == val) {
//            return res;
//        }
//        else {
//            head.next = res;
//            return head;
//        }

        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

}
