class Solution {
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        boolean[] visited = new boolean[row];
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < row; i++){
            if(!visited[i]){
                visited[i] = true;
                cnt++;
                queue.offer(i);
                while(!queue.isEmpty()){
                    int v = queue.poll();
                    for(int j = 0; j < row; j++){
                        if(isConnected[v][j] == 1 && !visited[j]){
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
