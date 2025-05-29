class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max_nums = new int[nums.length];
        int[] min_nums = new int[nums.length];
        max_nums[0] = min_nums[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            max_nums[i] = Math.max(Math.max(max_nums[i - 1] * nums[i], min_nums[i - 1] * nums[i]), nums[i]);
            min_nums[i] = Math.min(Math.min(max_nums[i - 1] * nums[i], min_nums[i - 1] * nums[i]), nums[i]);
        }
        return Arrays.stream(max_nums).max().getAsInt();
    }
}