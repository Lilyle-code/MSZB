class Solution {
public:
    int getSum(int n) {
        int sumres = 0;
        while (n != 0) {
            sumres = sumres + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sumres;
    }

    bool isHappy(int n) {
        unordered_set<int> sum;
        while (1) {
            if (n == 1) {
                return true;
            }
            if (sum.find(n) != sum.end()) {
                return false;
            }
            else {
                sum.insert(n);
                n = getSum(n);
            }
        }
    }
};