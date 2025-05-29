import jdk.nashorn.internal.ir.LiteralNode;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<List<String>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<ListNode> lists = new ArrayList<>();
        int len = Integer.parseInt(in.nextLine());
        for(int i = 0; i < len; i++){
            ListNode root = new ListNode();
            int[] nums = Arrays.stream(in.nextLine().trim().split(",")).
                    mapToInt(Integer::parseInt).toArray();
            root = root.ListBuilder(nums);
            lists.add(root);
        }
        Queue<ListNode> queue = new PriorityQueue<>((x, y) -> (x.val - y.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode node : lists){
            if(node != null) queue.add(node);
        }
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node.next != null) queue.add(node.next);
            cur.next = node;
            cur = cur.next;
        }
        dummy.printListNode(dummy.next);
    }
}
