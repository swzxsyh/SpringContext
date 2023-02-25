package com.test.application.algorithm.leetCode;

import com.test.application.algorithm.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode21 {

    public static void main(String[] args) {
        //l1 = [1,2,4], l2 = [1,3,4]
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 3, 4};


        ListNode head = new ListNode(0);

        ListNode l1 = head;

        for (int j : array1) {
            l1.next = new ListNode(j);
            l1 = l1.next;
        }
        l1 = head.next;

        ListNode head2 = new ListNode(0);
        ListNode l2 = head2;
        for (int i : array2) {
            l2.next = new ListNode(i);
            l2 = l2.next;
        }
        l2 = head2.next;

        ListNode result = new LeetCode21().mergeTwoLists(l1, l2);
        System.out.println("result: " + result);


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1.next != null && list2 != null) {


        }


        return list1;
    }
}
