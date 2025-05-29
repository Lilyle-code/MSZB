class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int right = searchRightboard(nums, target);
        int left = searchLeftboard(nums, target);
        if (right == -2 || left == -2)
            return { -1, -1 };
        else if (right - left > 1)
            return { left + 1, right - 1 };
        else
            return{ -1, -1 };
    }
    int searchRightboard(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        int rightboard = -2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                rightboard = left;
            }
        }
        return rightboard;
    }
    int searchLeftboard(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        int leftboard = -2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                leftboard = right;
            }
            else {
                left = mid + 1;
            }
        }
        return leftboard;
    }
};