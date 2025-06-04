class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        int n = nums.length;
        int[] res = new int [n - k + 1];
        Deque<Integer> slide = new LinkedList<>();
        for(int i = 0; i < k && i < nums.length; i++){
            while(!slide.isEmpty() && slide.getLast() < nums[i]){
                slide.pollLast();
            }
            slide.addLast(nums[i]);
        }
        res[0] = slide.getFirst();
        for(int i = k; i < nums.length; i++){
            if(slide.getFirst() == nums[i - k]){
                slide.pollFirst();
            }
            while(!slide.isEmpty() && slide.getLast() < nums[i]){
                slide.pollLast();
            }
            slide.addLast(nums[i]);
            res[i - k + 1] = slide.getFirst();
        }
        return res;
    }
}