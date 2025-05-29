class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] entry = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            int cur = arr[0];
            int pre = arr[1];
            entry[cur]++;
            adjacency.get(pre).add(cur);
        }
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(entry[i] == 0) queue.add(i);
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            cnt++;
            List<Integer> list = adjacency.get(cur);
            for(Integer i : list){
                entry[i]--;
                if(entry[i] == 0) queue.add(i);
            }
        }
        if(cnt == numCourses) return true;
        else return false;
    }
}