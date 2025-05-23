class Solution {
    private int[] coins;
    private int[][] cache;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        cache = new int[coins.length][amount + 1];
        for(int[] c : cache){
            Arrays.fill(c, -1);
        }
        int ans = dfs( coins.length - 1, amount);
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }
    private int dfs(int i, int amount){
        if(i < 0) return amount == 0 ? 0 : Integer.MAX_VALUE / 2;
        if(cache[i][amount] != -1) return cache[i][amount];
        if(amount < coins[i]) return cache[i][amount] = dfs(i - 1, amount);
        return cache[i][amount] = Math.min(dfs(i - 1, amount), dfs(i, amount - coins[i]) + 1);
    }
}