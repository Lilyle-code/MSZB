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
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < row; i++) {
            if(matrix[i][0] == 0){
                flagCol0 = true;
            }
        }
        for (int i = 0; i < col; i++) {
            if(matrix[0][i] == 0){
                flagRow0 = true;
            }
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(flagRow0){
            for(int i = 0; i < row; i++){
                matrix[0][i] = 0;
            }
        }
        if(flagCol0){
            for(int i = 0; i < col ; i++){
                matrix[i][0] = 0;
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
