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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;

        // while (l1 != null && l2 != null) {
        //     int sum = l1.val + l2.val + carry;
        //     int val = sum % 10;
        //     if (sum > 9) carry = 1;
        //     else carry = 0;
        //     ListNode node = new ListNode(val);
        //     dummy.next = node;
        //     dummy = dummy.next;
        //     l1 = l1.next;
        //     l2 = l2.next;
        // }

        // while (l1 != null) {
        //     int sum = l1.val + carry;
        //     int val = sum % 10;
        //     if (sum > 9) carry = 1;
        //     else carry = 0;
        //     ListNode node = new ListNode(val);
        //     dummy.next = node;
        //     dummy = dummy.next;
        //     l1 = l1.next;
        // }

        // while (l2 != null) {
        //     int sum = l2.val + carry;
        //     int val = sum % 10;
        //     if (sum > 9) carry = 1;
        //     else carry = 0;
        //     ListNode node = new ListNode(val);
        //     dummy.next = node;
        //     dummy = dummy.next;
        //     l2 = l2.next;
        // }


        while (l1 != null || l2 != null) { // optimal way to write above all three loops
            int sum = 0;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;
            if (carry > 0) sum += carry;
            int val = sum % 10;
            // if (sum > 9) carry = 1;
            if (sum > 9) carry = sum / 10; // better way to handle carry but you can use above if condition because total sum didn't exceed 19 value;
            else carry = 0;
            ListNode node = new ListNode(val);
            dummy.next = node;
            dummy = dummy.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }


        if (carry == 1) {
            ListNode node = new ListNode(carry);
            dummy.next = node;
        }

        return dummyHead.next;
    }
}
