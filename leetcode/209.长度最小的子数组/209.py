class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        sumvalue, i, substring, result = 0, 0, 0, float('inf')
        for j in range(len(nums)):
            sumvalue = sumvalue + nums[j]
            while sumvalue >= target:
                substring = j - i + 1
                result = result if result < substring else substring
                sumvalue = sumvalue - nums[i]
                i = i + 1
        return 0 if result == float('inf') else result