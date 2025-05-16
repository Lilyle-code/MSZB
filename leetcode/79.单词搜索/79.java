class Solution {
    public int[][] record;
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        record = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word,int nr, int nc, int cur){
        if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length || board[nr][nc] != word.charAt(cur) || record[nr][nc] == 1) return false;
        if(cur == word.length() - 1) return true;
        record[nr][nc] = 1;
        if (dfs(board, word, nr - 1, nc, cur + 1) || dfs(board, word, nr, nc - 1, cur + 1) ||
                dfs(board, word, nr + 1, nc, cur + 1) || dfs(board, word, nr, nc + 1, cur + 1)){
            return true;
        }
        record[nr][nc] = 0;
        return false;
    }
}