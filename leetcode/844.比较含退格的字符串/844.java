class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = checkStr(s.toCharArray());
        String s2 = checkStr(t.toCharArray());
        return s1.equals(s2);
    }
    public String checkStr(char[] str){
        int slow = 0;
        for(int fast = 0; fast < str.length; fast++){
            if(str[fast] != '#'){
                str[slow++] = str[fast];
            }else{
                slow = --slow >= 0 ? slow : 0;
            }
        }
        return new String(str).substring(0, slow);
    }
}