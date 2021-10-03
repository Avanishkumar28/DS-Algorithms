package algo.list;

import algo.leetcode.medium.ListNode;

/**
25. Reverse Nodes in k-Group (https://leetcode.com/problems/reverse-nodes-in-k-group/)
 **/

public class ReverseNodeKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        // Find the next head.
        int count = 0;
        ListNode nextHead = head;
        while (nextHead != null && count < k) {
            nextHead = nextHead.next;
            count++;
        }
        // If count < k, not enough nodes to reverse, remain as it is.
        if (count < k) return head;
        // Reverse next head list.
        nextHead = reverseKGroup(nextHead, k);
        // Reverse current k group sub-list.
        ListNode current = head, prev = nextHead;
        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
