class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount+1];
        return solve(coins, 0, amount);
    }
    private int solve(int[] coins, int idx, int amount){
        if(amount == 0) return 1;
        if(idx == coins.length) return 0;

        if(dp[idx][amount]!=null) return dp[idx][amount];

        int notTake = solve(coins, idx+1, amount);
        int take = 0;
        if(amount >= coins[idx]){
            take = solve(coins, idx, amount-coins[idx]);
        }
        return dp[idx][amount] = take + notTake;
    }
}