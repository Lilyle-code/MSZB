package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

public class Main {
    private static TreeNode pre = new TreeNode(0);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] tree = in.nextLine().split(" ");
        TreeNode root = TreeBuilder.buildTree(tree);
        flan(root);
        TreeBuilder.printTree(root);
    }
    public static void flan(TreeNode root) {
        if(root == null) return;
        flan(root.right);
        flan(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
