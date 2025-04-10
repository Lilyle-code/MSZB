class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        next = [0] * len(needle)
        self.getNext(next, needle)
        i, j = 0, 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            elif j > 0:
                j = next[j - 1]
            else:
                i += 1
            if j == len(needle):
                return i - j
        return -1

    def getNext(self, next, s:str):
        prefix_len, i = 0, 1
        while i < len(s):
            if s[prefix_len] == s[i]:
                prefix_len += 1
                next[i] = prefix_len
                i += 1
            else:
                if prefix_len == 0:
                    next[i] = prefix_len
                    i += 1
                else:
                    prefix_len = next[prefix_len - 1]