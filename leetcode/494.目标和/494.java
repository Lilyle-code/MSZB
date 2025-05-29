class Solution {
    private int[] nums;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        target = Math.abs(target) + Arrays.stream(nums).sum();
        if(target < 0 || target % 2 == 1) return 0;
        return dfs(nums.length - 1, target / 2);
    }
    private int dfs(int i, int target){
        if(i < 0){
            if(target == 0) return 1;
            else return 0;
        }
        if(target < nums[i]) return dfs(i - 1, target);
        return dfs(i - 1, target) + dfs(i - 1, target - nums[i]);
    }
}