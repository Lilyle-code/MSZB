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
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i = 0; i < row; i++){
            int left = 0, right = col - 1;
            while(left < right){
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
