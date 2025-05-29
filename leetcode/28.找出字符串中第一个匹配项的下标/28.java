class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        getNext(next, needle);
        int  i = 0, j = 0; 
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else if(j > 0){
                j = next[j - 1];
            }else{
                i++;
            }
            if(j == needle.length()) return i - j;
        }
        return -1;
    }
    public void getNext(int[] next, String s){
        int prefix_len = 0, i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(prefix_len)){
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
}