class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        for(int num=2;num<=n;num++){
            int ans = 0;
            for(int i=1;i<num;i++){
                int notBreak = i*(num-i);
                int Break = i*dp[num-i];
                ans = Math.max(ans, Math.max(notBreak, Break));
            }
            dp[num] = ans;
        }
        return dp[n];
    }
}