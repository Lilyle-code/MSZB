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
    public ListNode reverseList(ListNode head) {
        //双指针
        // ListNode cur = head;
        // ListNode pre = null;
        // while(cur != null){
        //     ListNode tmp = cur;
        //     cur = cur.next;
        //     tmp.next = pre;
        //     pre = tmp;
        // }
        // return pre;
        //递归
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}