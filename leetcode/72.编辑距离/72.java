class Solution {
    private char[] ch1;
    private char[] ch2;
    private int[][] cache;
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        ch1 = word1.toCharArray();
        ch2 = word2.toCharArray();
        cache = new int[len1][len2];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        return dfs(len1 - 1, len2 - 1);
    }
    private int dfs(int i, int j){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(cache[i][j] != -1) return cache[i][j];
        if(ch1[i] == ch2[j]) return cache[i][j] = dfs(i - 1, j - 1);
        return cache[i][j] = Math.min(Math.min(dfs(i - 1, j), dfs(i, j - 1)), dfs(i - 1, j - 1))+ 1;
    }
}