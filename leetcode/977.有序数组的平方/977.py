class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        i, j, k = 0, len(nums) - 1, len(nums) - 1
        res = [0] * len(nums)
        while i <= j :
            if abs(nums[i]) < abs(nums[j]):
                res[k] = nums[j] * nums[j]
                k = k - 1
                j = j - 1
            else:
                res[k] = nums[i] * nums[i]
                k = k - 1
                i = i + 1 
        return res