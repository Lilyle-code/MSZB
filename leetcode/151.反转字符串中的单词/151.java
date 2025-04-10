class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        ch = removeSpace(ch);
        reverse(ch, 0, ch.length - 1);
        int start = 0;
        for(int i = 0; i <= ch.length; i++){
            if(i == ch.length || ch[i] == ' '){
                reverse(ch, start, i - 1);
                start = i + 1;
            }
        }
        return new String(ch);
    }
    public void reverse(char[] ch, int start, int end){
        while(start < end){
            ch[start] ^= ch[end];
            ch[end] ^= ch[start];
            ch[start] ^= ch[end];
            start++;
            end--;
        }
    }
    public char[] removeSpace(char[] ch){
        int slow = 0;
        for(int fast = 0; fast < ch.length; fast++){
            if(ch[fast] != ' '){
                if(slow > 0) ch[slow++] = ' ';
                while(fast < ch.length && ch[fast] != ' '){
                    ch[slow++] = ch[fast++];
                }
            }
        }
        char[] newch = new char[slow];
        System. arraycopy(ch, 0, newch, 0, slow);
        return newch;
    }
}