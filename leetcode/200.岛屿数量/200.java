class Solution {
    public void dfs(char[][] grid, int row, int colum){
        int r = grid.length;
        int c = grid[0].length;
        if(row < 0 || colum < 0 || row >= r || colum >= c || grid[row][colum] == '0') return;
        grid[row][colum] = '0';
        dfs(grid, row - 1, colum);
        dfs(grid, row, colum - 1);
        dfs(grid, row + 1, colum);
        dfs(grid, row, colum + 1);
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int resnum = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(grid[i][j] == '1'){
                    resnum++;
                    dfs(grid, i, j);
                }
            }
        }
        return resnum;
    }
}