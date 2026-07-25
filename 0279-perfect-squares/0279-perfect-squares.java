class Solution {

    int[][] dp;
    int INF = (int)1e9;

    public int numSquares(int n) {

        int size = (int)Math.sqrt(n);

        int[] squares = new int[size];

        for (int i = 1; i <= size; i++) {
            squares[i - 1] = i * i;
        }

        dp = new int[size][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(squares, 0, n);
    }

    private int solve(int[] squares, int index, int amount) {

        if (amount == 0)
            return 0;

        if (index == squares.length)
            return INF;

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int notTake = solve(squares, index + 1, amount);

        int take = INF;

        if (squares[index] <= amount)
            take = 1 + solve(squares, index, amount - squares[index]);

        return dp[index][amount] = Math.min(take, notTake);
    }
}