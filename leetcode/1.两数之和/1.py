class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cnt = dict()
        for index, num in enumerate(nums):
            ano = target - num
            if ano in cnt:
                return [cnt[ano], index]
            cnt[num] = index
        return []
