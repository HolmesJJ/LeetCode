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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode sNode2 = node2;
        
        while (node1.next != null) {
            ListNode nNode1 = node1.next.next;
            node1.next = node1.next.next;
            if (node2.next != null) {
                ListNode nNode2 = node2.next.next;
                node2.next = node2.next.next;
                node2 = nNode2;
            }
            if (nNode1 == null) {
                node1.next = sNode2;
                break;
            } else if (nNode1.next == null) {
                nNode1.next = sNode2;
                break;
            }
            node1 = nNode1;
        }
        return head;
    }
}