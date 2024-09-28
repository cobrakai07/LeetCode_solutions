from collections import deque

class MyCircularDeque:
    def __init__(self, k: int):
        self.size = k
        self.dq = deque()
        self.curr = 0

    def insertFront(self, value: int) -> bool:
        if self.curr == self.size:
            return False
        self.dq.appendleft(value)
        self.curr += 1
        return True

    def insertLast(self, value: int) -> bool:
        if self.curr == self.size:
            return False
        self.dq.append(value)
        self.curr += 1
        return True

    def deleteFront(self) -> bool:
        if self.curr == 0:
            return False
        self.dq.popleft()
        self.curr -= 1
        return True

    def deleteLast(self) -> bool:
        if self.curr == 0:
            return False
        self.dq.pop() 
        self.curr -= 1
        return True

    def getFront(self) -> int:
        if self.curr == 0:
            return -1
        return self.dq[0]

    def getRear(self) -> int:
        if self.curr == 0:
            return -1
        return self.dq[-1] 

    def isEmpty(self) -> bool:
        return self.curr == 0

    def isFull(self) -> bool:
        return self.curr == self.size


