import java.util.*;

class Solution {

    int[][][] dp;
    int n, m;
    static final int NEG = -100000000; // impossible state

    public int solve(int i, int j, int[][] grid, int k) {

        // out of bounds
        if (i >= n || j >= m) return NEG;

        // already computed
        if (dp[i][j][k] != Integer.MIN_VALUE) {
            return dp[i][j][k];
        }

        // current cell cost
        int cost = (grid[i][j] == 0) ? 0 : 1;

        // cannot afford this cell
        if (k < cost) {
            return dp[i][j][k] = NEG;
        }

        // destination
        if (i == n - 1 && j == m - 1) {
            return dp[i][j][k] = grid[i][j];
        }

        int remain = k - cost;

        int right = solve(i, j + 1, grid, remain);
        int down = solve(i + 1, j, grid, remain);

        int best = Math.max(right, down);

        if (best == NEG) {
            return dp[i][j][k] = NEG;
        }

        return dp[i][j][k] = grid[i][j] + best;
    }

    public int maxPathScore(int[][] grid, int k) {

        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][k + 1];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        int ans = solve(0, 0, grid, k);

        return ans < 0 ? -1 : ans;
    }
}