class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        slow = 0
        for fast in range(0,len(nums)):
            if nums[fast] != 0:
                nums[slow] = nums[fast]
                slow = slow + 1
        for i in range(slow, len(nums)):
            nums[i] = 0
        