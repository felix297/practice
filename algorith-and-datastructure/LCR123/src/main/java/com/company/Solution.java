package com.company;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
public class Solution {
    public int[] run (int[] arr) {
        return reverseBookList(getListNode(arr));
    }

    public int[] reverseBookList(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        int length = 0;
        while (head != null) {
            System.out.println(head.val);
            stack.push(head.val);
            head = head.next;
            length++;
        }

        int[] res = new int[length];
        for (int index = 0; index < length; index++) {
            res[index] = stack.pop();
        }

        return res;
    }

    public ListNode getListNode (int[] arr) {
        ListNode head = new ListNode();
        head.val = arr[0];
        ListNode curr = new ListNode();
        head.next = curr;
        int length = arr.length;
        for (int index = 1; index < length; index++) {
//            System.out.println(arr[index]);
            curr.val = arr[index];
            if (index != length - 1) {
                ListNode next = new ListNode();
                curr.next = next;
                curr = curr.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
    }
}