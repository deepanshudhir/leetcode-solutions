class Solution {
    Integer[][] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[nums.length][target+1];
        return solve(nums, 0, target);
    }
    private int solve(int[] nums, int idx, int target){
        if(target==0) return 1;
        if(idx==nums.length) return 0;
        if(dp[idx][target]!=null) return dp[idx][target];

        int notTake = solve(nums, idx+1, target);

        int take=0;
        if(nums[idx]<=target){
            take = solve(nums,0,target-nums[idx]);
        }
        return dp[idx][target] = take+notTake;
    }
}