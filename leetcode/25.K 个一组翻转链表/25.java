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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        ListNode dummyNode = new ListNode(0, head);
        ListNode dummy = dummyNode;
        cur = head;
        ListNode pre = null;
        for(; len >= 0; len -= k){
            if(len < k) break;
            for(int i = 0; i < k; i++){
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            ListNode tmp = dummy.next;
            dummy.next.next = cur;
            dummy.next = pre;
            dummy = tmp;
        }
        return dummyNode.next;
    }
}