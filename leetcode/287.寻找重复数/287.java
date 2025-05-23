class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length;
        while(low < high){
            int mid = (low + high) / 2;
            int cnt = 0;
            for(int n : nums){
                if(n >= low && n <= mid) cnt++;
            }
            if(cnt > mid - low + 1){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}