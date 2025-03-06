class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int left = 0, right = matrix[0].length - 1, top  = 0, buttom = matrix.length -1;
        while(left <= right && top <= buttom){
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= buttom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left <= right && top <= buttom){
                for(int i = right; i>= left; i--){
                    res.add(matrix[buttom][i]);
                }
                buttom--;
                for(int i = buttom; i>= top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }

        }
        return res;
    }
}