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
    ListNode* reverseList(ListNode* head) {
        //Ë«Ö¸Õë
        // ListNode* cur = head;
        // ListNode* pre = NULL;
        // while(cur){
        //     ListNode* tmp = cur;
        //     cur = cur->next;
        //     tmp->next = pre;
        //     pre = tmp;
        // } 
        // return pre;
        //µÝ¹é
        if (head == NULL) return NULL;
        if (head->next == NULL) return head;
        ListNode* last = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return last;
    }
};