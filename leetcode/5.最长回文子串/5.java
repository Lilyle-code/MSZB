class Solution {
    private int[][] cache;
    public String longestPalindrome(String s) {
        cache = new int[s.length()][s.length()];
        int maxLen = 1, start = 0, end = 0;
        for(int i = 1; i < s.length(); i++){
            for(int j = 0; j < i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || cache[i - 1][j + 1] == 1)){
                    cache[i][j] = 1;
                }
                if(cache[i][j] == 1 && maxLen < i - j + 1){
                    maxLen = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}