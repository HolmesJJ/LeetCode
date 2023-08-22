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
    public void reorderList(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode rightNode = slowNode.next;
        slowNode.next = null;
        
        if (rightNode == null) {
            return;
        }

        ListNode preNode = rightNode;
        ListNode currNode = rightNode.next;
        preNode.next = null;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        ListNode node1 = head;
        ListNode node2 = preNode;
        while (node1 != null && node2 != null) {
            ListNode tempNode1 = node1.next;
            ListNode tempNode2 = node2.next;
            node1.next = node2;
            node2.next = tempNode1;
            node1 = tempNode1;
            node2 = tempNode2;
        }
    }
}

// 1 2 3 4
// 1 2 3 4 5