class Solution {
    public void traversal(TreeNode cur, List<Integer> ves){
        if(cur == null) return;
        traversal(cur.left, ves);
        ves.add(cur.val);
        traversal(cur.right, ves);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);
        return res;
    }
}