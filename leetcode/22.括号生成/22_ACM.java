import java.util.*;
import com.nowcoder.ListNode;

public class Main {
    private static List<String> res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        res = new ArrayList<>();
        int left = 0, right = 0;
        dfs(n, left, right, "");
        System.out.println(res);
    }
    public static void dfs(int num, int left, int right, String s) {
        if (left == num && right == num) {
            res.add(s);
            return;
        }
        if (left < num && right < left){
            dfs(num, left, right + 1, s + ")");
            dfs(num, left + 1, right, s + "(");
        }else if(left == num && right < num){
            dfs(num, left, right + 1, s + ")");
        }else{
            dfs(num, left + 1, right, s + "(");
        }
    }
}
