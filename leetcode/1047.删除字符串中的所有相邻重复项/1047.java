class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> sd = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(!sd.isEmpty() && sd.peek() == ch[i]){
                sd.pop();
            }else{
                sd.push(ch[i]);
            }
        }
        String str = "";
        while(!sd.isEmpty()){
            str = sd.pop() + str;
        }
        return str;
    }
}