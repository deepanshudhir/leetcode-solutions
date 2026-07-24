class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int x : nums) sum+=x;
        if(sum%2 != 0) return false;

        int target = sum/2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i=0;i<n;i++) dp[i][0] = true;

        for(int i=n-1;i>=0;i--){
            for(int t=1;t<=target;t++){
                boolean notTake = dp[i+1][t];
                boolean take = false;
                if(t>=nums[i]){
                    take = dp[i+1][t-nums[i]];
                }
                dp[i][t] = notTake || take;
            }
        }
        return dp[0][target];
    }
}