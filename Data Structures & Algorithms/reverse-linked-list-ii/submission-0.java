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

    private ListNode reverse(ListNode head, int len) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (len-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = curr;

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int ind = 1;
        ListNode curr = head;
        ListNode beforeLeft = null;

        while (ind < left) {
            beforeLeft = curr;
            curr = curr.next;
            ind++;
        }

        ListNode start = curr;
        ListNode reverseList = reverse(curr, right - left + 1);

        if (beforeLeft != null) beforeLeft.next = reverseList;
        else head = reverseList;

        return head;
    }
}