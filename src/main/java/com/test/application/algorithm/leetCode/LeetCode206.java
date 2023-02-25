package com.test.application.algorithm.leetCode;

import com.test.application.algorithm.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class LeetCode206 {

    public static void main(String[] args) {
        //TODO
        int[] nums = {1,2,3,4,5};

        ListNode head = new ListNode(0);
        ListNode nextNode;
        nextNode = head;

        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(i);
            nextNode.next = node;
            nextNode = nextNode.next;
        }

        nextNode = head;
        System.out.println(nextNode);
        System.out.println(head);


        ListNode result = new LeetCode206().reverseList(head);
        System.out.println("result:" + result);
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;


        return result;
    }

}
