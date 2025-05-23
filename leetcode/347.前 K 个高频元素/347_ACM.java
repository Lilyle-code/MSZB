package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.merge(nums[i], 1, Integer::sum);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey(), val = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < val){
                    queue.poll();
                    queue.offer(new int[]{key, val});
                }
            }else{
                queue.offer(new int[]{key, val});
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll()[0];
        }
        for(int i : res){
            System.out.print(i+ " ");
        }
    }
}
