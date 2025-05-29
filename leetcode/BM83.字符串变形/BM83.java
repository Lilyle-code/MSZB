/*
存在空格问题，但使用以下代码仍未通过：
public class Solution {
    public String trans(String s, int n) {
        String res = "";
        String tempStr = "";
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c>='a'&& c<='z')
                tempStr += Character.toUpperCase(c);
            else if(c>='A'&& c<='Z')
                tempStr += Character.toLowerCase(c);
            else{
                tempStr = c+tempStr;
                res = tempStr + res;
                tempStr="";
            }
        }
        res = tempStr+res;
        return res;
    }
}
 */
public class Solution {
    public String reverse(String word){
        StringBuilder sb = new StringBuilder();
        for(Character c : word.toCharArray()){
            if(Character.isLowerCase(c)){
                sb.append(Character.toUpperCase(c));
            }else if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public String trans (String s, int n) {
        // write code here
        if(s == null || n == 0) return s;
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            res.append(reverse(words[i]));
            res.append(' ');
        }
        return res.toString();
    }

}