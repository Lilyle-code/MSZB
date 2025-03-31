class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int cnt[26] = { 0 };
        for (int i = 0; i < magazine.size(); i++) {
            cnt[magazine[i] - 'a']++;
        }
        for (int i = 0; i < ransomNote.size(); i++) {
            cnt[ransomNote[i] - 'a']--;
        }
        for (const int& c : cnt) {
            if (c < 0)
                return false;
        }
        return true;
    }
};