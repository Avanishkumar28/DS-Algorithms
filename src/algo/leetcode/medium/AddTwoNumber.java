package algo.leetcode.medium;

import java.util.List;

/**
* 2. Add Two Numbers (https://leetcode.com/problems/add-two-numbers/)
**/

public class AddTwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        int carry = 0;
        ListNode head = null;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            head = addNewNode(head, sum%10);
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum/10;
            head = addNewNode(head, sum%10);
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum/10;
            head = addNewNode(head, sum%10);
            l2 = l2.next;
        }
        if(carry != 0){
            head = addNewNode(head, carry);
        }

        return head;
    }

    private static ListNode addNewNode(ListNode head, int val){
        if(head == null){
            head = new ListNode(val);
            return head;
        }

        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new ListNode(val);
        return head;
    }

    public static void main(String[] args) {
        ListNode test1head1 = new ListNode(4);
        ListNode test1Node2 = new ListNode(7);
        ListNode test1Node3 = new ListNode(9);
        test1head1.next = test1Node2;
        test1Node2.next = test1Node3;

        ListNode test1head2 = new ListNode(3);
        ListNode test1Node02 = new ListNode(5);
        ListNode test1Node03 = new ListNode(2);
        test1head2.next = test1Node02;
        test1Node02.next = test1Node03;

        ListNode resultNode = addTwoNumbers(test1head1, test1head2);
        //  479
        // +352
        //-----
        //  7221 --> 722 and 1 carry
        while (resultNode != null){
            System.out.print(resultNode.val);
            resultNode = resultNode.next;
        }


    }
}
