class Solution {
    public boolean solve(int ind , int tar , int[] nums, int n){
        boolean dp[][]=new boolean[n][tar+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }

        if(nums[0]<=tar){
            dp[0][nums[0]]=true;
        }

        for(int i=1;i<n;i++){
            for(int t=1;t<=tar;t++){
                boolean notTake=dp[i-1][t];
                boolean take=false;
                if(nums[i]<=t){
                    take=dp[i-1][t-nums[i]];
                }

                dp[i][t]=take|notTake;
            }
        }

        return dp[n-1][tar];

    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        return solve(n-1,sum/2,nums,n);

    }
}