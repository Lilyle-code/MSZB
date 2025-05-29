class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int result = 0;
        int i = 0;
        int substring = 0;
        unordered_map<int, int> cnt;
        for (int j = 0; j < fruits.size(); j++) {
            cnt[fruits[j]]++;
            while (cnt.size() > 2) {
                cnt[fruits[i]]--;
                if (cnt[fruits[i]] == 0) {
                    cnt.erase(fruits[i]);
                }
                i++;
            }
            substring = j - i + 1;
            result = result < substring ? substring : result;
        }
        return result;
    }
};