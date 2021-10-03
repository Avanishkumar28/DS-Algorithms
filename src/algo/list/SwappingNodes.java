package algo.list;

import algo.leetcode.medium.ListNode;
/**
1721. Swapping Nodes in a Linked List (https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)
        You are given the head of a linked list, and an integer k.
        Return the head of the linked list after swapping the values of the kth node from the beginning
        and the kth node from the end (the list is 1-indexed).
**/


public class SwappingNodes {

    public static ListNode swapNodes(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode current = head;
        ListNode start = head;
        ListNode end = head;

        while(--k > 0){
            current = current.next;
            start = start.next;
        }
        if(current == null)
            return head.next;

        while(current.next != null){
            current = current.next;
            end = end.next;
        }
        int temp = start.val;
        start.val = end.val;
        end.val = temp;

        return head;
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
        ListNode newList = swapNodes(head, 2);
        System.out.printf("\n Printing list after swapping the node at %d th node (from start and end) \n", 3);
        ListNode newListNode = newList;
        while (newListNode != null){
            System.out.print(newListNode.val);
            System.out.print(" ");
            newListNode = newListNode.next;
        }
    }
}
