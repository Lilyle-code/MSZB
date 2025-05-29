//方法一：递归 + 记忆化搜素
//class Solution {
//    private Map<Integer, Integer> map = new HashMap<>();
//    public int rob(int[] nums) {
//        return dfs(nums, nums.length - 1);
//    }
//    public int dfs(int[] arr, int node){
//        if(node < 0) return 0;
//        if(map.containsKey(node)) return map.get(node);
//        int cnt = Math.max(dfs(arr, node - 1), dfs(arr,node - 2) + arr[node]);
//        map.put(node, cnt);
//        return cnt;
//    }
//}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//方法二：递推
public class Main {
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        for(int i = 0; i < num; i++){
            int[] arr = Arrays.stream(in.nextLine().trim().split("\\s+")).
                    mapToInt(Integer::parseInt).
                    toArray();
            int[] result = new int[arr.length + 2];
            for(int j = 0; j < arr.length; j++){
                result[j + 2] = Math.max(result[j] + arr[j], result[j + 1]);
            }
            System.out.println(result[result.length - 1]);
        }

    }
}
/*
可进一步优化空间，第31 - 33行：
int f0 = 0, f1 = 0;
for(int i = 0; i < arr.length; i++){
    int new_f = Math.max(f0 + arr[i], f1);
    f0 = f1;
    f1 = new_f;
}
 */