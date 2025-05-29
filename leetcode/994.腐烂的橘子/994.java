class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        Deque<int[]> queue = new LinkedList<>();
        int freshornge = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1)
                    freshornge++;
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int flag = 0;
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                if ((cur[0] - 1) >= 0 && grid[cur[0] - 1][cur[1]] == 1) {
                    queue.offer(new int[] { cur[0] - 1, cur[1] });
                    grid[cur[0] - 1][cur[1]] = 2;
                    freshornge--;
                    flag = 1;
                }
                if ((cur[1] - 1) >= 0 && grid[cur[0]][cur[1] - 1] == 1) {
                    queue.offer(new int[] { cur[0], cur[1] - 1 });
                    grid[cur[0]][cur[1] - 1] = 2;
                    freshornge--;
                    flag = 1;
                }
                if ((cur[0] + 1) < grid.length && grid[cur[0] + 1][cur[1]] == 1) {
                    queue.offer(new int[] { cur[0] + 1, cur[1] });
                    grid[cur[0] + 1][cur[1]] = 2;
                    freshornge--;
                    flag = 1;
                }
                if ((cur[1] + 1) < grid[0].length && grid[cur[0]][cur[1] + 1] == 1) {
                    queue.offer(new int[] { cur[0], cur[1] + 1 });
                    grid[cur[0]][cur[1] + 1] = 2;
                    freshornge--;
                    flag = 1;
                }
            }
            if (flag == 1)
                res++;
        }
        if (freshornge > 0) {
            return -1;
        } else {
            return res;
        }
    }
}