class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        i, res,substring = 0, 0, 0
        cnt = defaultdict(int)
        for j, c in enumerate(fruits):
            cnt[c] += 1
            while len(cnt) > 2:
                cnt[fruits[i]] -= 1
                if(cnt[fruits[i]] == 0):
                    del cnt[fruits[i]]
                i += 1
            substring = j - i + 1
            res = substring if res < substring else res
        return res 
        