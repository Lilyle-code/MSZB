class Solution {
public:
    int strStr(string haystack, string needle) {
        int i = 0, j = 0;
        vector<int> next(needle.size(), 0);
        // next[0] = 0;
        getNext(&next[0], needle);
        while (i < haystack.size()) {
            if (haystack[i] == needle[j]) {
                i++;
                j++;
            }
            else if (j > 0) {
                j = next[j - 1];
            }
            else {
                i++;
            }
            if (j == needle.size()) {
                return i - j;
            }
        }
        return -1;
    }
    void getNext(int* next, const string& s) {
        int prefix_len = 0, i = 1;
        while (i < s.size()) {
            if (s[prefix_len] == s[i]) {
                next[i] = ++prefix_len;
                i++;
            }
            else {
                if (prefix_len == 0) {
                    next[i] = 0;
                    i++;
                }
                else {
                    prefix_len = next[prefix_len - 1];
                }
            }
        }
    }
};