class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAXX = 2048;

        boolean[][] dp = new boolean[4][MAXX];
        dp[0][0] = true;

        for (int v : nums) {
            boolean[][] next = new boolean[4][MAXX];

            for (int c = 0; c <= 3; c++) {
                System.arraycopy(dp[c], 0, next[c], 0, MAXX);
            }

            for (int cnt = 0; cnt <= 3; cnt++) {
                for (int x = 0; x < MAXX; x++) {
                    if (!dp[cnt][x]) continue;

                    if (cnt + 1 <= 3)
                        next[cnt + 1][x ^ v] = true;

                    if (cnt + 2 <= 3)
                        next[cnt + 2][x] = true;

                    if (cnt + 3 <= 3)
                        next[cnt + 3][x ^ v] = true;
                }
            }

            dp = next;
        }

        int ans = 0;
        for (boolean b : dp[3]) {
            if (b) ans++;
        }

        return ans;
    }
}