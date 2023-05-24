/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode pre = head;
        ListNode cur = head;
        boolean flag = false;
        while (cur != null && cur.next != null) {
            pre = pre.next;
            cur = cur.next.next;
            if (pre == cur) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}