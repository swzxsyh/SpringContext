package com.test.application.algorithm.leetCode;

import com.test.application.algorithm.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class LeetCode206 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            current.next = node;
            current = node;
        }
        System.out.println(head);


        ListNode result = new LeetCode206().reverseList(head);
        System.out.println("result:" + result);
    }

    public ListNode reverseList(ListNode head) {
        //始终保存反向节链表中的前一个节点
        ListNode prev = null;

        //not end
        while (head != null) {
            ListNode next = head.next;
            //set key as last key
            head.next = prev;
            //null = head{}
            prev = head;
            //head{5} = head{4}
            head = next;
        }
        return prev;
    }

}
