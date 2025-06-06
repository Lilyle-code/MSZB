class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length ==0 || nums.length == 1) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] nums, int start, int end){
        if(start >= nums.length || start >= end) return;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}