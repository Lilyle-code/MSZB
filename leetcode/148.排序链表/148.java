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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right =  sortList(tmp);
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(left != null && right != null){
            if(left.val > right.val){
                cur.next = right;
                right = right.next;
            }else{
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        // while(left != null || right != null){
        cur.next = left == null ? right : left;
        // }
        return res.next;
    }
}