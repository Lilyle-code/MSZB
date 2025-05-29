import com.nowcoder.TreeBuild;
import com.nowcoder.TreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] parts = in.nextLine().split(" ");
        TreeNode root = TreeBuild.buildTree(parts);
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            int cur;
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(i == n - 1){
                    result.add(node.val);
                }
            }
        }
        System.out.println(result);
    }
}