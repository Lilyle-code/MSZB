import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<List<String>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = in.nextInt();
        ListNode head = new ListNode();
        head = head.ListBuilder(nums);
        ListNode dummyNode = new ListNode(0, head);
        ListNode dummy = dummyNode;
        ListNode pre = null;
        ListNode cur = head;
        for(int n = nums.length - 1; n >= 0; n -= k){
            if(n < k) break;
            for(int i = 0; i < k; i++){
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            ListNode tmp = dummy.next;
            dummy.next.next = cur;
            dummy.next = pre;
            dummy = tmp;
        }
        cur = dummyNode.next;
        while(cur != null){
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }
    }
}
