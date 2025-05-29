class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        slow = 0
        for fast in range(0, len(nums)):
            if nums[slow] != nums[fast]:
                slow = slow + 1
                nums[slow] = nums[fast]
        return slow+1
        