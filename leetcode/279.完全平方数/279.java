class Solution {
    private int[][] cache;
    public int numSquares(int n) {
        int sq = (int)Math.floor(Math.sqrt(n));
        cache = new int[sq + 1][n + 1];
        for(int[] c : cache){
            Arrays.fill(c, -1);
        }
        int ans = dfs(sq, n);
        return ans;
    }
    private int dfs(int sq, int n){
        if(sq <= 0) return n == 0 ? 0 : Integer.MAX_VALUE / 2;
        if(cache[sq][n] != -1) return cache[sq][n];
        if(n < Math.pow(sq, 2)) return cache[sq][n] = dfs(sq - 1, n);
        return cache[sq][n] = Math.min(dfs(sq - 1, n), dfs(sq, (int)(n - Math.pow(sq, 2)))+ 1);
    }
}