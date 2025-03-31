class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length ==0 || nums2 == null || nums2.length == 0)
            return new int[0];
        Set<Integer> result = new HashSet<>();
        Set<Integer> cnt = new HashSet<>();
        for(int i:nums1){
            cnt.add(i);
        }
        for(int i:nums2){
            if(cnt.contains(i)){
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}