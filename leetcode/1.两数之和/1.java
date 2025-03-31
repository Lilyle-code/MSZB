class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int ano = target - nums[i];
            if(cnt.containsKey(ano)){
                return new int[]{cnt.get(ano), i};
            }
            cnt.put(nums[i], i);
        }
        return new int[]{};
    }
}