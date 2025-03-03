class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast=0; fast < nums.length; fast++){
            if(val != nums[fast]){
                nums[slow++] = nums[fast];  
            }
        }
        return slow;
    }
}