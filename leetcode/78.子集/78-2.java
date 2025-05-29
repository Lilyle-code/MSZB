/*
解法二：大于等于下表i的元素选或者不选
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return result;
    }
    public void dfs(int[] nums, int curposition){
        result.add(new ArrayList<>(path));
        if(curposition == nums.length) return;

        for(int i = curposition; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}