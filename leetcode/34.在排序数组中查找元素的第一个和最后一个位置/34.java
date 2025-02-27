class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        if(left == -2 || right == -2){
            return new int[]{-1, -1};
        }else if(right - left > 1){
            return new int[]{left+1,right-1};
        }else{
            return new int[]{-1,-1};
        }
    }
    public int searchRight(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int rightboard = -2;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid +1;
                rightboard = left;
            }
        }
        return rightboard;
    }
    public int searchLeft(int[] nums, int target){
        int left = 0, right = nums.length -1;
        int leftboard = -2;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] >= target){
                right = mid - 1;
                leftboard = right;
            }else{
                left = mid + 1;
            }
        }
        return leftboard;
    }
}