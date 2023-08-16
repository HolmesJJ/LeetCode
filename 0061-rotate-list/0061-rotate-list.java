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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int i = 0;
        while (node != null) {
            map.put(i, node);
            node = node.next;
            i++;
        }
        ListNode endNode = map.get(map.size() - k % map.size() - 1);
        ListNode lastNode = map.get(map.size() - 1);
        ListNode startNode = map.get(0);
        if (endNode.next != null) {
            startNode = endNode.next;
            lastNode.next = map.get(0);
        }
        endNode.next = null;
        return startNode;
    }
}