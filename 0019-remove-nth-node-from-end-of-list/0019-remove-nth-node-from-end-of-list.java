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
        // 前后指针：后指针比前指针快n
        int prev = 0;
        int cur = n;
        
        ListNode prevNode = head;
        ListNode curNode = head;
        
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        
        if (curNode == null) {
            return head.next;
        }
        
        while (curNode.next != null) {
            prevNode = prevNode.next;
            curNode = curNode.next;
        }
        
        prevNode.next = prevNode.next.next;
        
        return head;
    }
}