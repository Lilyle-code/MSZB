class MyQueue:

    def __init__(self):
        self.stackIn = []
        self.stackOut = []

    def push(self, x: int) -> None:
        self.stackIn.append(x)

    def pop(self) -> int:
        if self.empty():
            return None
        self.dumpstackIn()  # 转移数据（仅在 stackOut 为空时）
        return self.stackOut.pop()

    def peek(self) -> int:
        if self.empty():
            return None
        self.dumpstackIn()  # 转移数据（仅在 stackOut 为空时）
        return self.stackOut[-1]

    def empty(self) -> bool:
        # 队列为空当且仅当两个栈均为空
        return not self.stackIn and not self.stackOut

    def dumpstackIn(self):
        # 仅当 stackOut 为空时，从 stackIn 中转移全部数据
        if not self.stackOut:
            while self.stackIn:
                self.stackOut.append(self.stackIn.pop())