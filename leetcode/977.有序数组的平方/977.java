class Solution {
    public int[] sortedSquares(int[] nums) {
        int k = nums.length - 1;
        int[] result = new int[nums.length];
        for(int i = 0, j = nums.length - 1; i <= j; ){
            if(Math.abs(nums[i]) < Math.abs(nums[j])){
                result[k--] = nums[j] * nums[j];
                j--;
            }else{
                result[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return result;
    }
}