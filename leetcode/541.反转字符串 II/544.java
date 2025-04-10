class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i = i + 2 * k){
            int end = Math.min(i + k - 1, ch.length - 1);
            for(int j = i; j < end; j++, end--){
                char tmp = ch[j];
                ch[j] = ch[end];
                ch[end] = tmp;
                   
            }
        }
        return new String(ch);
    }
}