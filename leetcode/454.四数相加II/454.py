class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        unordered_map<int, int> cntAB;
        int res = 0;
        for(const int &a:nums1){
            for(const int &b:nums2){
                cntAB[a + b]++;
            }
        }
        for(const int &c:nums3){
            for(const int &d:nums4){
                int ano = 0 - (c + d);
                if(cntAB.find(ano) != cntAB.end()){
                    res = res + cntAB[ano];
                }
            }
        }
        return res;
    }
};