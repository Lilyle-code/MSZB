class Solution {
    public void getNext(int[] next, String s){
        int prefix_len = 0, i = 1;
        while(i < s.length()){
            if(s.charAt(prefix_len) == s.charAt(i)){
                next[i++] = ++prefix_len; 
            }else{
                if(prefix_len == 0){
                    next[i++] = 0;
                }else{
                    prefix_len = next[prefix_len - 1];
                }
            }
        }
    }
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        getNext(next, s);
        int len = s.length();
        if(next[len - 1] != 0 && len % (len - next[len - 1]) == 0){
            return true;
        }
        return false;
    }
}