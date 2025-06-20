class Solution {
    public int solve(int ind, int buy, int[] prices, int[][] dp,int n){
        if(ind==n){
            return 0;
        }

        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        int profit=Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max(solve(ind+1,0,prices,dp,n)-prices[ind],solve(ind+1,1,prices,dp,n));
        }else{
            profit=Math.max(solve(ind+1,1,prices,dp,n)+prices[ind],solve(ind+1,0,prices,dp,n));
        }

        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }

        return solve(0,1,prices,dp,n);
    }
}