class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        permuteHelper(nums);
        return res;
    }
    public void permuteHelper(int[] nums) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}