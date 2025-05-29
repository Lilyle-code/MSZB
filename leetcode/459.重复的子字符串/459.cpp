class Solution {
public:
    void getNext(vector<int>& next, string& s) {
        int prefix_len = 0, i = 1;
        while (i < s.size()) {
            if (s[prefix_len] == s[i]) {
                next[i++] = ++prefix_len;
            }
            else {
                if (prefix_len == 0) {
                    next[i++] = 0;
                }
                else {
                    prefix_len = next[prefix_len - 1];
                }
            }
        }
    }
    bool repeatedSubstringPattern(string s) {
        vector<int> next(s.size());
        next[0] = 0;
        getNext(next, s);
        int len = s.size();
        if (next[len - 1] != 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }
};