/*
解法一：数组中的每个元素选或者不选
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list);
        return result;
    }
    public void dfs(int[] nums, int cur_position, List<Integer> list){
        if(cur_position == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, cur_position + 1, list);
        list.add(nums[cur_position]);
        dfs(nums, cur_position + 1, list);
        list.remove(list.size() - 1);
    }
}