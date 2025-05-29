class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        return quickSort(list, k);
    }
    private int quickSort(List<Integer> list, int k){
        Random rand = new Random();
        int pivot = list.get(rand.nextInt(list.size()));
        List<Integer> high = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> low = new ArrayList<>();
        for(int i : list){
            if(i > pivot) high.add(i);
            else if(i < pivot) low.add(i);
            else equal.add(i);
        }
        if(k <= high.size()) return quickSort(high, k);
        if(k > equal.size() + high.size()) return quickSort(low, k - (high.size() + equal.size()));
        return pivot;
    }
}