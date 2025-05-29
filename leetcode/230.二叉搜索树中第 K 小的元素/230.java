class Solution {
    List<Integer> midtra = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        travel(root);
        if(k <= midtra.size()){
            return midtra.get(k - 1);
        }
        return - 1;
    }
    public void travel(TreeNode t){
        if(t == null) return;
        travel(t.left);
        midtra.add(t.val);
        travel(t.right);
    }
}