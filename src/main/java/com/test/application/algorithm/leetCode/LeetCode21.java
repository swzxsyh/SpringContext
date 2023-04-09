package com.test.application.algorithm.leetCode;

import com.test.application.algorithm.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode21 {

    public static void main(String[] args) {
        //l1 = [1,2,4], l2 = [1,3,4]
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 3, 5};
        final LeetCode21 cls = new LeetCode21();
        ListNode l1 = cls.buildParams(array1);
        ListNode l2 = cls.buildParams(array2);

        System.out.println(l1);
        System.out.println(l2);


        ListNode result = cls.mergeTwoLists(l1, l2);
        System.out.println("result: " + result);


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        if (l1 != null) {
            currentNode.next = l1;
        }

        if (l2 != null) {
            currentNode.next = l2;
        }

        return dummyHead.next;
    }


    private ListNode buildParams(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            current.next = node;
            current = node;
        }
        return head;
    }
}
