/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, targetSum, 0L, cnt);
        return res;
    }
    private void dfs(TreeNode root, int targetSum, Long sum, Map<Long, Integer> cnt){
        if(root == null) return;
        sum += root.val;
        res += cnt.getOrDefault(sum - targetSum, 0);
        cnt.merge(sum, 1, Integer::sum);
        dfs(root.left, targetSum, sum, cnt);
        dfs(root.right, targetSum, sum, cnt);
        cnt.merge(sum, -1, Integer::sum);
    }
}