class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        partitionHelper(s, 0);
        return res;
    }
    public void partitionHelper(String str, int curposition){
        if(curposition == str.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = curposition; i < str.length(); i++){
            String sub = str.substring(curposition, i + 1);
            if(isPalindrome(sub)){
                path.add(sub);
                partitionHelper(str, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String str){
        int left = 0, right= str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}