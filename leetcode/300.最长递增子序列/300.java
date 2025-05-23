class Solution {
    private int[] cache;
    private int[] nums;
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        cache = new int[nums.length];
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }
    private int dfs(int i){
        if(cache[i] != 0) return cache[i];
        for(int  j = 0; j < i; j++){
            if(nums[j] < nums[i]) cache[i] = Math.max(cache[i], dfs(j));
        }
        return ++cache[i];
    }
}