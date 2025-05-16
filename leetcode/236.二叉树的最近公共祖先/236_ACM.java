package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        TreeBuilder builder = new TreeBuilder();
        TreeNode root = builder.buildTree(in.nextLine().split(","));
        TreeNode p = new TreeNode(in.nextInt());
        TreeNode q = new TreeNode(in.nextInt());
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
