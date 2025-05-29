class Solution {
public:
    bool backspaceCompare(string s, string t) {
        string s1 = checkstr(s);
        string s2 = checkstr(t);
        if (s1.compare(s2) == 0)
            return true;
        else
            return false;
    }
    string checkstr(string str) {
        int slow = 0;
        for (int fast = 0; fast < str.length(); fast++) {
            if (str[fast] != '#') {
                str[slow++] = str[fast];
            }
            else {
                slow = --slow >= 0 ? slow : 0;
            }
        }
        return str.substr(0, slow);
    }
};