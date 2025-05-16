package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        TreeBuilder builder = new TreeBuilder();
        TreeNode root = builder.buildTree(in.nextLine().split(","));
        int targetSum = in.nextInt();
        System.out.println(pathSum(root, targetSum));
    }
    private static int res = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, targetSum, 0L, cnt);
        return res;
    }
    private static void dfs(TreeNode root, int targetSum, Long sum, Map<Long, Integer> cnt) {
        if (root == null) return;
        sum += root.val;
        res += cnt.getOrDefault(sum - targetSum, 0);
        cnt.merge(sum, 1, Integer::sum);
        dfs(root.left, targetSum, sum, cnt);
        dfs(root.right, targetSum, sum, cnt);
        cnt.merge(sum, -1, Integer::sum);
    }
}
