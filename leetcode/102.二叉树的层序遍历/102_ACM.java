package com.nowcoder;

import java.awt.*;
import java.util.*;
import java.util.List;

import com.nowcoder.TreeNode;
import com.nowcoder.TreeBuilder;
import com.nowcoder.ListNode;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
        String[] parts = in.nextLine().split(" ");
        TreeNode root = TreeBuilder.buildTree(parts);
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            int len = q.size();
            List<Integer> line = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                line.add(node.val);
            }
            res.add(line);
        }
        System.out.println(res);
    }
}
