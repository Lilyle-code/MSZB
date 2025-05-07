class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int left = 0, right = 0;
        dfs(n, left, right, "");
        return res;
    }
    public void dfs(int num, int left, int right, String s) {
        if (left == num && right == num) {
            res.add(s);
            return;
        }
        if (left < num && right < left){
            dfs(num, left, right + 1, s + ")");
            dfs(num, left + 1, right, s + "(");
        }else if(left == num && right < num){
            dfs(num, left, right + 1, s + ")");
        }else{
            dfs(num, left + 1, right, s + "(");
        }
    }
}