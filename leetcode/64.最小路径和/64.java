class Solution {
    private int[][] grid;
    private int[][] cache;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int row = grid.length, col = grid[0].length;
        cache = new int[row][col];
        for(int[] c : cache){
            Arrays.fill(c, -1);
        }
        return dfs(row - 1, col - 1);
    }
    private int dfs(int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return Integer.MAX_VALUE / 2;
        if(cache[row][col] != -1 ) return cache[row][col];
        if(row == 0 && col == 0) return cache[row][col] = grid[row][col];
        return cache[row][col] = Math.min(dfs(row - 1, col), dfs(row, col - 1)) + grid[row][col];
    }
}