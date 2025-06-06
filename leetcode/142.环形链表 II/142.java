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
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow){
            ListNode index1 = head;
            ListNode index2 = fast;
            while(index1 != index2){
                index1 = index1.next;
                index2 = index2.next;
            }
            if(index1 == index2){
                return index2;
            }
           }
        }
        return null;
    }
}