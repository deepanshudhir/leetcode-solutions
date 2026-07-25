class Solution {
    Integer[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int total=0;
        for(int x : stones) total+=x;

        dp = new Integer[stones.length][total/2 + 1];

        int sum = solve(stones,0,0,total/2);
        return total - 2*sum;
    }
    private int solve(int[] stones,int idx, int currSum, int target){
        if(idx == stones.length) return currSum;

        if(dp[idx][currSum]!=null) return dp[idx][currSum];

        int notTake = solve(stones, idx+1, currSum, target);

        int take = currSum;
        if(currSum + stones[idx] <= target){
            take = solve(stones, idx+1, currSum + stones[idx], target);
        }

        return dp[idx][currSum] = Math.max(take, notTake);
    }
}