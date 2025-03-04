class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int sum = 0;
        int substring = 0;
        int result = INT32_MAX;
        int i = 0;
        for (int j = 0; j < nums.size(); j++) {
            sum += nums[j];
            while (sum >= target) {
                substring = j - i + 1;
                result = result < substring ? result : substring;
                sum -= nums[i++];
            }
        }
        return result == INT32_MAX ? 0 : result;
    }
};