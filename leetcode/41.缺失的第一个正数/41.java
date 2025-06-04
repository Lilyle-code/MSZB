class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int position = nums[i] - 1;
            if(position >= 0 && position < nums.length && nums[i] != nums[position]){
                int tmp = nums[i];
                nums[i] = nums[position];
                nums[position] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}