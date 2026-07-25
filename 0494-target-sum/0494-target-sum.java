class Solution {
    Integer[][] dp;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        total = 0;
        for(int x : nums) total+=x;

        dp = new Integer[n][2*total + 1];
        return solve(0,0,nums, target);
    }
    private int solve(int idx, int sum, int[] nums, int target){
        if(idx==nums.length){
            return sum==target ? 1 : 0;
        }

        if(dp[idx][sum+total] != null) return dp[idx][sum+total];

        int minus = solve(idx+1,sum-nums[idx],nums, target);
        int plus = solve(idx+1,sum+nums[idx], nums, target);

        return dp[idx][sum+total] = minus + plus;
    }
}