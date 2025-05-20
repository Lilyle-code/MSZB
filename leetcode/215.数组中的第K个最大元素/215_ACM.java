package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        System.out.println(quickSort(list, k));
    }
    private static int quickSort(List<Integer> list, int k){
        Random rand = new Random();
        int pivot = list.get(rand.nextInt(list.size()));
        List<Integer> high = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> low = new ArrayList<>();
        for(int i : list){
            if(i > pivot) high.add(i);
            else if(i < pivot) low.add(i);
            else equal.add(i);
        }
        if(k <= high.size()) return quickSort(high, k);
        if(k > high.size() + equal.size()) return quickSort(low, k- (high.size() + equal.size()));
        return pivot;
    }
}
