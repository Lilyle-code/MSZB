class Solution {
    public void traversal(TreeNode cur, List<Integer> vec){
        if(cur == null) return;
        vec.add(cur.val);
        traversal(cur.left, vec);
        traversal(cur.right, vec);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);
        return res;
    }
}