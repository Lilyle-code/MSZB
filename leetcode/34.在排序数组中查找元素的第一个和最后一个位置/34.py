class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def searchRight(nums:List[int], target:int) ->int:
            left, right = 0, len(nums) -1
            rightboard = -2
            while left <= right:
                mid  = (left + right) //2
                if nums[mid] > target:
                    right = mid - 1
                else:
                    left = mid+1
                    rightboard = left
            return rightboard

        def searchLeft(nums:List[int], target:int)->int:
            left, right = 0, len(nums) - 1
            leftboard = -2
            while left<=right:
                mid = (left + right) //2
                if nums[mid] >= target:
                    right = mid - 1
                    leftboard = right
                else:
                    left = mid + 1
            return leftboard

        left = searchLeft(nums, target)
        right = searchRight(nums,target)
        if left == -2 or right == -2: 
            return [-1, -1]
        elif (right - left) > 1:
            return [left+1, right -1]
        else:
            return [-1,-1]
    
    