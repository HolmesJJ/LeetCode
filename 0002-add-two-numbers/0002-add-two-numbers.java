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
        String s1 = "";
        while (l1 != null) {
            s1 = l1.val + s1;
            l1 = l1.next;
        }
        String s2 = "";
        while (l2 != null) {
            s2 = l2.val + s2;
            l2 = l2.next;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l = Math.min(c1.length, c2.length);
        String s = "";
        int carry = 0;
        for (int i = 0; i < l; i++) {
            int d1 = c1[c1.length - 1 - i] - '0';
            int d2 = c2[c2.length - 1 - i] - '0';
            int d = d1 + d2 + carry;
            carry = d / 10;
            d = d % 10;
            s = d + s;
        }
        while (l < c1.length) {
            int d1 = c1[c1.length - 1 - l] - '0';
            int d = d1 + carry;
            carry = d / 10;
            d = d % 10;
            s = d + s;
            l++;
        }
        while (l < c2.length) {
            int d2 = c2[c2.length - 1 - l] - '0';
            int d = d2 + carry;
            carry = d / 10;
            d = d % 10;
            s = d + s;
            l++;
        }
        if (carry > 0) {
            s = carry + s;
        }
        char[] c = s.toCharArray();
        ListNode head = new ListNode(c[c.length - 1] - '0');
        ListNode node = head;
        for (int i = c.length - 2; i >= 0; i--) {
            node.next = new ListNode(c[i] - '0');
            node = node.next;
        }
        return head;
    }
}