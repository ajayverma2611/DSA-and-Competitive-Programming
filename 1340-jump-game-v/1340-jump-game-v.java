class Solution {

    int[] dp;

    public int solve(int i, int[] arr, int n, int d) {

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = 1;

        // move left
        for (int j = i - 1; j >= 0 && j >= i - d; j--) {

            // blocker found
            if (arr[j] >= arr[i]) {
                break;
            }

            ans = Math.max(ans, 1 + solve(j, arr, n, d));
        }

        // move right
        for (int j = i + 1; j < n && j <= i + d; j++) {

            // blocker found
            if (arr[j] >= arr[i]) {
                break;
            }

            ans = Math.max(ans, 1 + solve(j, arr, n, d));
        }

        return dp[i] = ans;
    }

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        dp = new int[n];

        Arrays.fill(dp, -1);

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i, arr, n, d));
        }

        return ans;
    }
}