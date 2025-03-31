class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        for i in range(0, len(nums)):
            if nums[i] > 0:
                break
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            left = i + 1
            right = len(nums) - 1
            while left < right:
                cursum = nums[i] + nums[left] + nums[right]
                if cursum > 0:
                    right -= 1
                elif cursum < 0:
                    left += 1
                else:
                    result.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    while left< right and nums[left] == nums[left + 1]:
                        left += 1
                    right -= 1
                    left += 1
        return result