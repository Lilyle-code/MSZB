import jdk.nashorn.internal.ir.LiteralNode;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] tree = in.nextLine().split(",");
        TreeNode root = new TreeNode();
        root = root.treeBuilder(tree);
        root.treePrinter(root);
        dfs(root);
        System.out.println(res);
    }
    private static int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        res = Math.max(res, root.val + left + right);
        return Math.max(left,right) + root.val;
    }
}
