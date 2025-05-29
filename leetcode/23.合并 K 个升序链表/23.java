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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((x, y) -> (x.val - y.val));
        for(ListNode node : lists){
            if(node != null) queue.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node.next != null) queue.add(node.next);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}