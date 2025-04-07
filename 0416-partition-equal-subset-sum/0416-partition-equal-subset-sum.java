class Solution {
    // public boolean solve(int ind , int sum , int[] nums , int[][] dp){
    //     if(sum==0){
    //         return true;
    //     }
    //     if(ind == 0){
    //         return nums[ind]==sum;
    //     }

    //     if(dp[ind][sum]!=-1){
    //         return dp[ind][sum]==1;
    //     }

    //     boolean notTake=solve(ind-1,sum,nums, dp);
    //     boolean take=false;

    //     if(nums[ind]<=sum){
    //         take=solve(ind-1,sum-nums[ind],nums,dp);
    //     }

    //     boolean ret=take||notTake;
    //     dp[ind][sum]=ret?1:0;

    //     return ret;
    // }
    // public boolean canPartition(int[] nums) {
        
    //     int n =nums.length;
    //     int total=0;

    //     for(int i=0;i<n;i++){
    //         total+=nums[i];
    //     }

    //     if(total%2!=0){
    //         return false;
    //     }

    //     int sum=total/2;

    //     int dp[][]=new int[n][sum+1];
    //     for(int r[] : dp){
    //         Arrays.fill(r,-1);
    //     }


    //     return solve(n-1,sum,nums,dp);
    // }


    //========================================== Tabulation =================================

    public boolean canPartition(int[] nums) {
        
        int n =nums.length;
        int total=0;

        for(int i=0;i<n;i++){
            total+=nums[i];
        }

        if(total%2!=0){
            return false;
        }

        int sum=total/2;

        boolean dp[][]=new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }

        if(nums[0]<=sum){
            dp[0][nums[0]]=true;
        }

        for(int ind=1 ;ind<n ;ind++){
            for(int target=0;target<=sum;target++){
                boolean notTake=dp[ind-1][target];
                boolean take=false;
                if(nums[ind]<=target){
                    take=dp[ind-1][target-nums[ind]];
                }

                dp[ind][target]=take||notTake;
            }
        }
        return dp[n-1][sum];
    }
}