class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        tab = {}
        for n in nums1:
            tab[n] = tab.get(n, 0) + 1
        result = set()
        for n in nums2:
            if n in tab:
                result.add(n)
                del tab[n]
        return list(result)