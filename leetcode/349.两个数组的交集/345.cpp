class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> result;
        unordered_set<int> cnt(nums1.begin(), nums1.end());
        for (const int& n : nums2) {
            if (cnt.find(n) != cnt.end()) {
                result.insert(n);
            }
        }
        return vector<int>(result.begin(), result.end());
    }
};