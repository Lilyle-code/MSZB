class Solution {
    private int[] cache;
    private Set<String> words;
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for(String word : wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        int len = s.length();
        cache = new int[len + 1];
        Arrays.fill(cache, -1);
        words = new HashSet<>(wordDict);
        int ans = dfs(len, maxLen, s);
        return ans == 1 ? true : false;
    }
    private int dfs(int i, int maxLen, String s){
        if(i ==0 ) return 1;
        if(cache[i] != -1) return cache[i];
        for(int j = i - 1; j >= Math.max(i - maxLen, 0); j--){
            if(words.contains(s.substring(j, i)) && dfs(j, maxLen, s) == 1) return cache[i] = 1;
        }
        return cache[i] = 0;
    }
}