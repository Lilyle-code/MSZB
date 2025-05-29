# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummyNode = ListNode(0, head)
        cur = dummyNode
        while cur.next and cur.next.next :
            tmp1 = cur.next
            tmp2 = cur.next.next.next
            cur.next = cur.next.next
            cur.next.next = tmp1
            cur.next.next.next = tmp2
            cur = cur.next.next
        return dummyNode.next