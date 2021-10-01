package cisco;

import algo.leetcode.medium.ListNode;

/**
 * Delete kth node from the last
 * given head of the node and int k
 *
 * */
public class DeleteNode {

    public static ListNode deleteKthNodeFromLast(ListNode head, int k){
        if (head == null)
            return null;
        ListNode current  = head;
        ListNode kNode = head;
        while (k-- > 0){
            current = current.next;
        }
        if(current == null)
            return head.next;  // handle edge case of single element

        while(current.next!=null){
            current = current.next;
            kNode =  kNode.next;
        }
        kNode.next = kNode.next.next;
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


        ListNode newList = deleteKthNodeFromLast(head, 3);
        System.out.printf("\n Printing list after deletion of %d th node: ", 3);
        ListNode newListNode = newList;
        while (newListNode != null){
            System.out.print(newListNode.val);
            System.out.print(" ");
            newListNode = newListNode.next;
        }

        ListNode newList1 = deleteKthNodeFromLast(head, 7);
        System.out.printf("\n Printing list after deletion of %d th node: ", 7);
        ListNode newListNode1 = newList1;
        while (newListNode1 != null){
            System.out.print(newListNode1.val);
            System.out.print(" ");
            newListNode1 = newListNode1.next;
        }
    }
}
