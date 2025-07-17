class Solution {
    public int maximumLength(int[] nums, int k) {
        
        int n=nums.length;
        int res=Integer.MIN_VALUE;
        int dp[][]=new int[k][n];

        for(int r[] : dp){
            Arrays.fill(r,1);
        }

        for(int i=0;i<n;i++){
            for(int j=0; j<i; j++){

                int mod=(nums[i]+nums[j])%k;
                dp[mod][i]=Math.max(dp[mod][i],1+dp[mod][j]);
                res=Math.max(res,dp[mod][i]);

            }
        }


        return res;
    }
}