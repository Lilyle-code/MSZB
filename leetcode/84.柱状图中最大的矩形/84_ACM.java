import com.sun.javafx.image.IntPixelGetter;
import jdk.nashorn.internal.ir.LiteralNode;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] heights = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> st = new ArrayDeque<>();
        int res = 0;
        st.push(-1);
        for(int right = 0; right <= heights.length; right++){
            int h = right < heights.length ? heights[right] : -1;
            while(st.size() > 1 && h <= heights[st.peek()]){
                int cur_height = heights[st.pop()];
                int left = st.peek();
                res = Math.max(res, cur_height * (right - left - 1));
            }
            st.push(right);
        }
        System.out.println(res);
    }
}
