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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode cur = dummyNode;
        while(cur.next != null && cur.next.next !=null){
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = tmp1;
            cur.next.next.next = tmp2;
            cur = cur.next.next;
        }
        head = dummyNode.next;
        return head;
    }
}