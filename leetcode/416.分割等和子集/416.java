class Solution {
    private int[][] cache;
    private int[] nums;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int target = Arrays.stream(nums).sum();
        if(target % 2 == 1) return false;
        cache = new int[nums.length][target / 2 + 1];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        return dfs(nums.length - 1, target / 2) == 1 ? true : false;
    }
    private int dfs(int i, int target){
        if(i < 0) return target == 0 ? 1 : 0;
        if(cache[i][target] != -1) return cache[i][target];
        if(target < nums[i]) return cache[i][target] = dfs(i - 1, target);
        return cache[i][target] = Math.max(dfs(i - 1, target), dfs(i - 1, target - nums[i])) ;
    }
}