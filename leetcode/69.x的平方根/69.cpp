class Solution {
public:
    int mySqrt(int x) {
        int left = 0, right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long long)mid * mid > x) {
                right = mid - 1;
            }
            else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
};