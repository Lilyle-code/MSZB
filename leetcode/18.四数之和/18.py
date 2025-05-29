class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        nums.sort()
        for i in range(len(nums)):
            # if nums[i] > 0 and nums[i] > target:
            #     break
            if i > 0 and nums[i] == nums[i-1]:
                continue
            t1 = target - nums[i]
            for j in range(i+1, len(nums)):
                # if nums[j] >= 0 and nums[j] > target:
                #     break
                if j > i + 1 and nums[j] == nums[j-1]:
                    continue
                left, right = j + 1, len(nums) - 1
                while left < right:
                    cursum = nums[j] + nums[left] + nums[right]
                    if cursum > t1:
                        right -= 1
                    elif cursum < t1:
                        left += 1
                    else:
                        res.append([nums[i], nums[j], nums[left], nums[right]])
                        while left< right and nums[right] == nums[right - 1]:
                            right -= 1
                        while left< right and nums[left] == nums[left + 1]:
                            left += 1
                        right -= 1
                        left += 1
        return res
