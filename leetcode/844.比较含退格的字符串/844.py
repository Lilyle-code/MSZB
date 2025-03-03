class Solution:
    def get_string(self, m: str) -> str :
        m = list(m)
        slow = 0
        for fast in range(0, len(m)):
            if(m[fast] != '#'):
                m[slow] = m[fast]
                slow = slow +1
            else:
                slow = slow-1 if slow-1>=0 else 0
        return ''.join(m[0:slow] )
    
    def backspaceCompare(self, s: str, t: str) -> bool:
        return self.get_string(s) == self.get_string(t)
        