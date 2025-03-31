class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > target && nums[i] >= 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            long t1 = target - nums[i];
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums[j] > t1 && nums[j] >= 0) break;
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;
                int left = j + 1, right = nums.size() - 1;
                while (left < right) {
                    long cursum = (long)nums[j] + (long)nums[left] + (long)nums[right];
                    if (cursum > t1) right--;
                    else if (cursum < t1) left++;
                    else {
                        res.push_back(vector<int>{nums[i], nums[j], nums[left], nums[right]});
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
};
};