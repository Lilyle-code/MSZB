class Solution {
    public void sortColors(int[] nums) {
        int slow = 0, fast = 0;
        for(int i = 0; i < nums.length; i++){
            int cur_num = nums[i];
            nums[i] = 2;
            if(cur_num <= 1) nums[fast++] = 1;
            if(cur_num == 0) nums[slow++] = 0;
        }
    }
}