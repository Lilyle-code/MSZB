class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        s = s[::-1]
        s = ' '.join(word[::-1] for word in s.split())
        return s
