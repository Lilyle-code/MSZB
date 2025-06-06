class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flagCol0 = false, flagRow0 = false;
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if(matrix[i][0] == 0){
                flagCol0 = true;
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if(matrix[0][i] == 0){
                flagRow0 = true;
                break;
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
        if(flagCol0){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
        if(flagRow0){
            for(int i = 0; i < col ; i++){
                matrix[0][i] = 0;
            }
        }
    }
}