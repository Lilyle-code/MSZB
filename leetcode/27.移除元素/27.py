class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        slow= 0
        for fast in range(0, len(nums)):
            if val != nums[fast]:
                nums[slow] = nums[fast]
                slow = slow + 1
        return slow        