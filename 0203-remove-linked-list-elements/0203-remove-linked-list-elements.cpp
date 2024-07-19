/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* prev = new ListNode(0);
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        prev = dummy;
        ListNode* curr = head;
        while (curr != nullptr) {
            if (curr->val == val) {
                cout << curr->val << endl;
                prev->next = curr->next;
            } else {
                prev = prev->next;
            }
            curr = curr->next;
        }
        return dummy->next;
    }
};