# Definition for singly - linked list.
# class ListNode :
    #     def __init__(self, x) :
    #         self.val = x
    #         self.next = None

    class Solution :
    def getIntersectionNode(self, headA: ListNode, headB : ListNode)->ListNode :
    curA = headA
    curB = headB
    lenA = 0
    lenB = 0
    while curA :
        lenA += 1
        curA = curA.next
        while curB :
            lenB += 1
            curB = curB.next
            curA = headA
            curB = headB
            if lenB > lenA:
tmp = lenA
lenA = lenB
lenB = tmp
tmpnode = curA
curA = curB
curB = tmpnode
gap = lenA - lenB
for i in range(gap) :
    curA = curA.next
    gap -= 1
    while curA :
        if curA == curB :
            return curA
            curA = curA.next
            curB = curB.next
            return None
