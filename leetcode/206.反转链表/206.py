# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #双指针
        # cur = head
        # pre = = None
        # while cur:
        #     tmp = cur
        #     cur = cur.next
        #     tmp.next = pre
        #     pre = tmp
        # return pre
        # 递归
        if head == None:
            return None
        if head.next == None:
            return head
        last = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return last