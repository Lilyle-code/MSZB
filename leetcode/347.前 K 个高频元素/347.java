class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.merge(nums[i], 1, Integer::sum);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey(), val = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < val){
                    queue.poll();
                    queue.offer(new int[]{key,val});
                }
            }else{
                queue.offer(new int[]{key,val});
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll()[0];
        }
        return res;
    }
}