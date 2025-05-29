class Solution {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] col = new int[n];
        boolean[] isChosen = new boolean[n];
        boolean[] r_diagonal = new boolean[2 * n - 1];
        boolean[] l_diagonal = new boolean[2 * n - 1];
        dfs(0, n, col, isChosen, r_diagonal, l_diagonal);
        return res;
    }
    private void dfs(int i, int n, int[] col, boolean[] isChosen, boolean[] r_diagonal, boolean[] l_diagonal){
        if(i == n){
            List<String> path = new ArrayList<>();
            for(int c : col){
                char[] ch = new char[n];
                Arrays.fill(ch, '.');
                ch[c] = 'Q';
                path.add(new String(ch));
            }
            res.add(new ArrayList(path));
            return;
        }
        for(int k = 0; k < n; k++){
            if(!isChosen[k] && !r_diagonal[i + k] && !l_diagonal[i - k + n - 1]){
                col[i] = k;
                isChosen[k] = r_diagonal[i + k] = l_diagonal[i - k + n - 1] = true;
                dfs(i + 1, n, col, isChosen, r_diagonal, l_diagonal);
                isChosen[k] = r_diagonal[i + k] = l_diagonal[i - k + n - 1] = false;

            }
        }
    }
}