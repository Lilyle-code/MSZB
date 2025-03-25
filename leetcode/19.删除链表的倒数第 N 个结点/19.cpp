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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummyNode = new ListNode(0, head);
        ListNode* fast = dummyNode;
        ListNode* slow = dummyNode;
        for (; n > 0; n--) {
            fast = fast->next;
        }
        while (fast != NULL && fast->next != NULL) {
            slow = slow->next;
            fast = fast->next;
        }
        fast = slow->next->next;
        slow->next = fast;
        head = dummyNode->next;
        delete(dummyNode);
        return head;

    }
};