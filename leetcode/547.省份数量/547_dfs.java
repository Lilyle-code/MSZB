class Solution {
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        boolean[] visited = new boolean[row];
        int cnt = 0;
        for(int i = 0; i < row; i++){
            if(!visited[i]){
                cnt++;
                dfs(i, isConnected, visited);
            }
        }
        return cnt;
    }
    private static void dfs(int row, int[][] isConnected, boolean[] visited){
        visited[row] = true;
        for(int j = 0; j < isConnected[0].length; j++){
            if(isConnected[row][j] == 1 && !visited[j]){
                dfs(j, isConnected, visited);
            }
        }
    }
}
