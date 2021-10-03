package algo.list;

import algo.leetcode.medium.ListNode;

/**
24. Swap Nodes in Pairs (https://leetcode.com/problems/swap-nodes-in-pairs/)
        Given a linked list, swap every two adjacent nodes and return its head.
        You must solve the problem without modifying the values in the list's nodes
        (i.e., only nodes themselves may be changed.)
 **/

public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        prev.next = head;

        while (prev.next != null) {
            ListNode first = prev.next;
            if (first == null) break;

            ListNode second = first.next;
            if (second == null) break;
            ListNode third = second.next;

            //swap
            prev.next = second;
            second.next = first;
            prev = first;
            prev.next = third;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i<=10; i++){
            current.next = new ListNode(i);
            current = current.next;
        }
        ListNode node = head;
        while (node != null){
            System.out.print(node.val);
            System.out.print(" ");
            node = node.next;
        }
        ListNode newList = swapPairs(head);
        System.out.printf("\n Printing list after swapping \n");
        ListNode newListNode = newList;
        while (newListNode != null){
            System.out.print(newListNode.val);
            System.out.print(" ");
            newListNode = newListNode.next;
        }
    }
}
