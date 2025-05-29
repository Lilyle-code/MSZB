class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cntAB = new HashMap<>();
        int res = 0;
        for(int a:nums1){
            for(int b:nums2){
                int one = a + b;
                cntAB.put(one, cntAB.getOrDefault(one, 0) + 1); 
            }
        }
        for(int c:nums3){
            for(int d:nums4){
                int ano = 0 - (c + d);
                res = res + cntAB.getOrDefault(ano, 0);
            }
        }
        return res;
    }
}