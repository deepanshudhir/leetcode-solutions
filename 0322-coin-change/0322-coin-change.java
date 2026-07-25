class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = solve(coins, 0, amount);
        return ans>=1000000 ? -1 : ans;
    }
    private int solve(int [] coins, int idx, int amount){
        if(amount == 0) return 0;
        if(idx == coins.length) return 1000000;
        if(dp[idx][amount]!=-1) return dp[idx][amount];

        int notTake = solve(coins, idx+1, amount);

        int take = 1000000;
        if(amount >= coins[idx]){
            take = 1+solve(coins, idx, amount - coins[idx]);
        }
        return dp[idx][amount] = Math.min(take, notTake); 
    }
}