/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // int len = 0;
        // ListNode curr = head;

        // while (curr != null) {
        //     len++;
        //     curr = curr.next;
        // }

        // int traversingLen = len - n;

        // if (traversingLen == 0) return head.next;

        // curr = head;

        // while (traversingLen > 1) {
        //     traversingLen--;
        //     curr = curr.next;
        // }

        // curr.next = curr.next.next;

        // return head;




        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
