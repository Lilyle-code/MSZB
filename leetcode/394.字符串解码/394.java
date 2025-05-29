class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        LinkedList<Integer> cur_num = new LinkedList<>();
        LinkedList<String> cur_list = new LinkedList<>();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '['){
                cur_num.add(num);
                cur_list.add(res.toString());
                num = 0;
                res = new StringBuilder();
            }else if(s.charAt(i) == ']'){
                int cnt = cur_num.removeLast();
                StringBuilder tmp = new StringBuilder();
                for(int j = 0; j < cnt; j++){
                    tmp.append(res);
                }
                res = new StringBuilder(cur_list.removeLast() + tmp);
            }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num = num * 10 + Integer.parseInt(s.charAt(i) + "");
            }else res.append(s.charAt(i));
        }
        return res.toString();
    }
}