class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int j=0;j<n;j++) dp[0][j] = matrix[0][j];

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int up = dp[i-1][j];
                int upLeft = (j>0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int upRight = (j<n-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up,Math.min(upLeft,upRight));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(ans,dp[n-1][i]);
        }
        return ans;

    }
}