class Solution {
    public boolean isValid(String s) {
        Stack<Character> sd = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i =0; i < ch.length; i++){
            if(ch[i] == ')' && !sd.isEmpty() && sd.peek() == '('){
                sd.pop();
            }else if(ch[i] == ']' && !sd.isEmpty() && sd.peek() == '['){
                sd.pop();
            }else if(ch[i] == '}' && !sd.isEmpty() && sd.peek() == '{'){
                sd.pop();
            }else{
                sd.push(ch[i]);
            }
        }
        return sd.isEmpty();
    }
}