# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        size = 0
        temp = head
        while temp!=None:
            size+=1
            temp = temp.next

        if size==1:
            return None
            
        size = size//2
        
        temp = head

        while size>1:
            temp = temp.next
            size-=1

        if temp.next!=None:
            delnode = temp.next
            temp.next = delnode.next
        
        return head