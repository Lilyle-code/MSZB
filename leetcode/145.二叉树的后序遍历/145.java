class Solution {
    public void traversal(TreeNode cur, List<Integer> ves){
        if(cur == null )return;
        traversal(cur.left, ves);
        traversal(cur.right, ves);
        ves.add(cur.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);
        return res;
    }
}