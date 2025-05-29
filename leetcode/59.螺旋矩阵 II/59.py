class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        maxtrix = [[0] * n for _ in range(n)]
        left, right, top, buttom = 0, n-1, 0, n-1
        cnt = 1
        while left <= right and top <= buttom and cnt <= n*n:
            for i in range(left, right):
                maxtrix[top][i] = cnt
                cnt += 1
            for i in range(top, buttom):
                maxtrix[i][right] = cnt
                cnt += 1
            if left == right and top == buttom:
                maxtrix[top][left] = cnt
                cnt += 1
            if left < right and top < buttom:
                for i in range(right, left, -1):
                    maxtrix[buttom][i] = cnt
                    cnt += 1
                for i in range(buttom, top, -1):
                    maxtrix[i][left] = cnt
                    cnt += 1

            left += 1
            right -= 1
            top += 1
            buttom -= 1
        return maxtrix

        