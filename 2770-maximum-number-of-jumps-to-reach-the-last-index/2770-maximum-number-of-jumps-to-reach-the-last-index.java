class Solution {
    int dp[];

    public int solve(int i, int[] nums, int t) {
        if (i == nums.length - 1) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int maxi = Integer.MIN_VALUE;

        for (int j = i + 1; j < nums.length; j++) {
            int sum = nums[j] - nums[i];

            if (t * -1 <= sum && sum <= t) {
                int tmp = solve(j, nums, t);

                if (tmp != Integer.MIN_VALUE) {
                    maxi = Math.max(maxi, 1 + tmp);
                }
            }
        }

        return dp[i] = maxi;
    }

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = solve(0, nums, target);

        return ans == Integer.MIN_VALUE ? -1 : ans - 1;
    }
}