class Solution {
    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl","mno", "pqrs", "tuv","wxyz"};
    private ArrayList<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        int len = digits.length();
        if(len == 0) return res;
        dfs(digits, 0, "");
        return res;
    }
    public void dfs(String digits, int num, String s){
        if(num == digits.length()) {
            res.add(s);
            return;
        }
        String tele = map[digits.charAt(num) - '0'];
        for(int i = 0; i < tele.length(); i++){
            dfs(digits, num + 1, s + tele.charAt(i));
        }

    }
}