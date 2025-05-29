package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
//        快慢指针，但测试用例[3，3，3]不适用
//        int slow = 0, fast = 0;
//        do {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        }while(slow != fast);
//        slow = 0;
//        while(slow != fast){
//            slow = nums[slow];
//            fast = nums[fast];
//        }
//        System.out.println(slow);
        int low = 1, high = nums.length;
        while(low < high){
            int mid = (low + high) / 2;
            int cnt = 0;
            for(int j : nums){
                if(j <= mid && j >= low) cnt++;
            }
            if(cnt > mid - low + 1){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
