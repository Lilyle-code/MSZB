class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int[] cache = new int[s.length()];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    cache[i] = (i - 2 >=0 ? cache[i - 2] : 0) + 2;
                }else if(s.charAt(i - 1) == ')' && i - cache[i - 1] - 1 >= 0 && s.charAt(i - cache[i - 1] - 1) == '('){
                    cache[i] = cache[i - 1] + (i - cache[i - 1] - 2 >= 0 ? cache[i - cache[i - 1] - 2] : 0) + 2;
                }
            }
            res = Math.max(res, cache[i]);
        }
        return res;
    }
}