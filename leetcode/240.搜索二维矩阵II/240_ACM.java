package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int target = in.nextInt();
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        int i = 0, j = col - 1;
        while(i < row && j >= 0){
            if(matrix[i][j] == target){
                System.out.println("Yes");
                return;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        System.out.println("No");
    }
}
