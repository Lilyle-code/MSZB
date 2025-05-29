class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> matrix(n, vector<int>(n, 0));
        int left = 0, right = n - 1, top = 0, buttom = n - 1;
        int cnt = 1;
        while (left <= right && top <= buttom && cnt <= n * n) {
            if (left == right && top == buttom) {
                matrix[top][left] = cnt++;
            }
            for (int i = left; i < right; i++) {
                matrix[top][i] = cnt++;
            }
            for (int i = top; i < buttom; i++) {
                matrix[i][right] = cnt++;
            }
            if (left < right&& top < buttom) {
                for (int i = right; i > left; i--) {
                    matrix[buttom][i] = cnt++;
                }
                for (int i = buttom; i > top; i--) {
                    matrix[i][left] = cnt++;
                }
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        return matrix;
    }
};