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
    bool isPalindrome(ListNode* head) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* p1 = head;
        ListNode* p2 = head;
        ListNode* prev = nullptr;
        ListNode* next = nullptr;
        while (p2 != nullptr && p2->next != nullptr) {
            p2 = p2->next->next;
            next = p1->next;
            p1->next = prev;
            prev = p1;
            p1 = next;
        }
        if (p2 != nullptr) {
            p1 = p1->next;
        }
        while (p1 != nullptr && prev != nullptr) {
            if (p1->val != prev->val) {
                return false;
            }
            p1 = p1->next;
            prev = prev->next;
        }
        if (p1 != nullptr || prev != nullptr) {
            return false;
        }
        return true;
    }
};