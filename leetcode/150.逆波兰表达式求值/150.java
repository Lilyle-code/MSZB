class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> sk = new Stack<>();
        for(String s : tokens){
            if("+".equals(s)){
                sk.push(sk.pop() + sk.pop());
            }else if("-".equals(s)){
                sk.push(-sk.pop() + sk.pop());
            }else if("*".equals(s)){
                sk.push(sk.pop() * sk.pop());
            }else if("/".equals(s)){
                int tmp1 = sk.pop();
                int tmp2 = sk.pop();
                sk.push(tmp2 / tmp1);
            }else{
                sk.push(Integer.valueOf(s));
            }
        }
        return sk.pop();
    }
}