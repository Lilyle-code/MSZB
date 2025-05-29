class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        cnt = [0]*26
        for i in magazine:
            cnt[ord(i) -ord("a")] += 1
        for i in ransomNote:
            cnt[ord(i)- ord("a")] -= 1
        for i in cnt:
            if i < 0:
                return False
        return True