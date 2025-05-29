class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, res);
        return res;
    }
    private static void dfs(int[] nums, int index, int target, List<Integer> path, List<List<Integer>> res) {
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i< nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i, target - nums[i], path, res);
            path.remove(path.size()-1);
        }
    }

}