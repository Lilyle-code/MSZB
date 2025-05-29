class Solution {
    private char[] ch1;
    private char[] ch2;
    private int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
        ch1 = text1.toCharArray();
        ch2 = text2.toCharArray();
        cache = new int[ch1.length][ch2.length];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        return dfs(ch1.length - 1, ch2.length - 1);
    }
    private int dfs(int i, int j){
        if(i < 0 || j < 0) return 0;
        if(cache[i][j] != -1) return cache[i][j];
        if(ch1[i] == ch2[j]) return cache[i][j] = dfs(i - 1, j - 1) + 1;
        return cache[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
    }
}
