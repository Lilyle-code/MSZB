class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> cnt;
        // vector<int> result;
        // if(nums.size() == 0 || nums.size() == 1)
        //     return {};
        // cnt.insert(nums[0]);
        for (int i = 0; i < nums.size(); i++) {
            int ano = target - nums[i];
            if (cnt.find(ano) != cnt.end()) {
                return { cnt[ano], i };
            }
            cnt[nums[i]] = i;
        }
        return {};
    }
};