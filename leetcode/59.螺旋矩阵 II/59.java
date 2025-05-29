class Solution {
    public int[][] generateMatrix(int n) {
        int[][] maxtrix = new int[n][n];
        int cnt = 1;
        int left = 0, right = n - 1, top = 0, buttom = n -1;
        while(left <= right && top <= buttom && cnt <= n*n){
            for(int i = left; i < right; i++){
                maxtrix[top][i] = cnt++;
            }
            for(int i = top; i<buttom;i++){
                maxtrix[i][right] = cnt++;
            }
            if(left < right && top < buttom){
                for(int i = right; i > left; i--){
                    maxtrix[buttom][i] = cnt++;
                }
                for(int i = buttom; i > top; i--){
                    maxtrix[i][left] = cnt++;
                }
            }
            if(left == right && top == buttom){
                maxtrix[top][left] = cnt++;
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        return maxtrix;
    }
}