package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int[] preorder;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        preorder = Arrays.stream(in.nextLine().trim().split(" ")).
                mapToInt(Integer::parseInt).toArray();
        int[] inorder = Arrays.stream(in.nextLine().trim().split(" ")).
                mapToInt(Integer::parseInt).toArray();
        TreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }
    private static TreeNode buildTree(int[] preorder, int[] inorder){
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return builder(0, 0, inorder.length - 1);
    }
    private static TreeNode builder(int root, int start, int end){
        if(start > end) return null;
        TreeNode t = new TreeNode(preorder[root]);
        int root_inorder = map.get(preorder[root]);
        t.left = builder(root + 1, start, root_inorder - 1);
        t.right = builder(root + root_inorder - start + 1, root_inorder + 1, end);
        return t;
    }
    private static void printTree(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
