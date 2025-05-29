class Solution:
    def getNext(self, next, s):
        prefix_len, i = 0, 1
        while i < len(s):
            if s[prefix_len] == s[i]:
                prefix_len += 1
                next[i] = prefix_len
                i += 1
            else:
                if prefix_len == 0:
                    next[i] = 0
                    i += 1
                else:
                    prefix_len = next[prefix_len - 1]

    def repeatedSubstringPattern(self, s: str) -> bool:
        next = [0] * len(s)
        self.getNext(next, s)
        l = len(s)
        if(next[l - 1] != 0 and l % (l - next[l - 1]) == 0):
            return True
        return False