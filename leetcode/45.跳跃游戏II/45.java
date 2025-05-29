import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().trim().split("\\s+")).
                mapToInt(Integer :: parseInt).toArray();
        int maxreach = 0;
        int cnt = 0;
        int end = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxreach = Math.max(maxreach, i + nums[i]);
            if(i == end){
                end = maxreach;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
