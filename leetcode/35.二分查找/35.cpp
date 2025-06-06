class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int n = nums.size();
        // if(n == 0 || target < nums[0]) return 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return right + 1;
    }
};