class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        int row = matrix.size();
        int column = matrix[0].size();
        int left = 0, right = column - 1, top = 0, buttom = row - 1;
        while (left <= right && top <= buttom) {
            for (int i = left; i <= right; i++) {
                res.push_back(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= buttom; i++) {
                res.push_back(matrix[i][right]);
            }
            right--;
            if (left <= right && top <= buttom) {
                for (int i = right; i >= left; i--) {
                    res.push_back(matrix[buttom][i]);
                }
                buttom--;
                for (int i = buttom; i >= top; i--) {
                    res.push_back(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
};