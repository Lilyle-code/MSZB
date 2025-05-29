import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取输入长度和起止点
        int len = in.nextInt();
        int start = in.nextInt();
        int end = in.nextInt();

        // 输入合法性判断
        if (len < 0 || start < 0 || end < 0 || start > len || end > len) {
            System.out.println(0);
            return;
        }

        // 如果起点和终点一样
        if (start == end) {
            System.out.println(0);
            return;
        }

        // 清空 visited 集合，防止静态变量污染
        visited.clear();

        // 计算从 start 到 end 的路径数
        int res = dfs(start, end, len);
        System.out.println(res);
    }

    // 递归搜索路径数
    public static int dfs(int current, int target, int len) {
        // 越界或重复访问
        if (current < 0 || current > len || visited.contains(current)) {
            return 0;
        }

        // 到达终点
        if (current == target) {
            return 1;
        }

        // 标记当前节点为已访问
        visited.add(current);

        // 尝试四个方向
        int paths = dfs(current + 1, target, len)
                + dfs(current - 1, target, len)
                + dfs(current + 2, target, len)
                + dfs(current - 2, target, len);

        // 回溯，撤销访问标记
        visited.remove(current);

        return paths;
    }
}
