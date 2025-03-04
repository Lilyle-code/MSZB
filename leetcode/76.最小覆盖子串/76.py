class Solution:
    def __init__(self):
        self.ori = defaultdict(int)
        self.cnt = defaultdict(int)

    def check(self)->bool:
        for key, val in self.ori.items():
            if self.cnt[key] < val:
                return False
        return True

    def minWindow(self, s: str, t: str) -> str:
        for i in range(len(t)):
            self.ori[t[i]] += 1
        left, right, sub, i = 0, 0, 0, 0
        res = sys.maxsize
        for j in range(len(s)):
            self.cnt[s[j]] += 1
            while self.check():
                sub = j - i + 1
                if sub < res:
                    left = i
                    right = j
                    res = sub
                self.cnt[s[i]] -= 1
                i += 1
        return "" if res == sys.maxsize else s[left: right+1]
        