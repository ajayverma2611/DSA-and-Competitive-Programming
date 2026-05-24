class Solution {

    int[] dp;

    public boolean check(int i, int j, int[] arr) {

        if (arr[i] <= arr[j]) {
            return false;
        }

        if (i < j) {

            for (int k = i + 1; k < j; k++) {
                if (arr[k] >= arr[i]) {
                    return false;
                }
            }

        } else {

            for (int k = i - 1; k > j; k--) {
                if (arr[k] >= arr[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public int solve(int i, int[] arr, int n, int d) {

        // memoization
        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = 1;

        // left
        for (int j = i - 1; j >= i - d && j >= 0; j--) {

            if (check(i, j, arr)) {
                ans = Math.max(ans, 1 + solve(j, arr, n, d));
            }
        }

        // right
        for (int j = i + 1; j <= i + d && j < n; j++) {

            if (check(i, j, arr)) {
                ans = Math.max(ans, 1 + solve(j, arr, n, d));
            }
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