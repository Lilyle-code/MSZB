class Solution {
public:
    unordered_map<char, int> cnt, t_cnt;
    bool check() {
        for (auto& i : t_cnt) {
            if (cnt[i.first] < i.second) {
                return false;
            }
        }
        return true;
    }
    string minWindow(string s, string t) {
        // unordered_map<char, int> cnt, t_cnt;
        for (const auto& c : t) {
            ++t_cnt[c];
        }
        int i = 0, substring = 0;
        int left = -1, right = -1;
        int res = INT32_MAX;
        for (int j = 0; j < s.length(); j++) {
            ++cnt[s[j]];
            while (check()) {
                substring = j - i + 1;
                if (substring < res) {
                    left = i;
                    right = j;
                    res = substring;
                }
                cnt[s[i]]--;
                if (cnt[s[i]] == 0) {
                    cnt.erase(s[i]);
                }
                i++;
            }

        }
        return res == INT32_MAX ? "" : s.substr(left, right - left + 1);
    }
};