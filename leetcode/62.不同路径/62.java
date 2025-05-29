class Solution {
    private int[][] cache;
    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        return dfs(m -1, n -1);
    }
    private int dfs(int i, int j){
        if(i < 0 || j < 0) return 0;
        if(cache[i][j] != -1) return cache[i][j];
        if(i == 0 || j == 0) return cache[i][j] = 1;
        return cache[i][j] = dfs(i - 1, j) + dfs(i, j -1);
    }
}