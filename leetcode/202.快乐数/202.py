class Solution:
    def getSum(self, n: int) -> int:
        sumres = 0
        while n:
            n, r = divmod(n, 10)
            sumres += r ** 2
        return sumres

    def isHappy(self, n: int) -> bool:
        cnt = set()
        while True:
            n = self.getSum(n)
            if n == 1:
                return True
            if n in cnt:
                return False
            else:
                cnt.add(n)

