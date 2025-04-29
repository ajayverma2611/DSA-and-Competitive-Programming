class Solution {
    public int solve(int ind , int trans ,int n,  int prices[], int dp[][]){
        if(ind==n ||  trans==4){
            return 0;
        }

        if(dp[ind][trans]!=-1){
            return dp[ind][trans];
        }

        int price=Integer.MIN_VALUE;
        if(trans%2==0){
            price=Math.max(-prices[ind]+solve(ind+1,trans+1,n,prices,dp),0+solve(ind+1,trans,n,prices,dp));
        }else{
            price=Math.max(prices[ind]+solve(ind+1,trans+1,n,prices,dp),0+solve(ind+1,trans,n,prices,dp));
        }

        return dp[ind][trans]=price;
    }
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int dp[][]=new int[n][4];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }
        return solve(0,0,n,prices,dp);
    }

    //================================== Tabulation =================================================================
    
    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     int dp[][][]=new int[n+1][2][3];

    //     for(int i=0;i<n;i++){ // base case cap=0;
    //         for(int buy=0;buy<2;buy++){
    //             dp[i][buy][0]=0;
    //         }
    //     }

    //     for(int buy=0;buy<2;buy++){
    //         for(int cnt=0;cnt<=2;cnt++){
    //             dp[n][buy][cnt]=0;
    //         }
    //     }

    //     for(int i=n-1;i>=0;i--){
    //         for(int buy=0;buy<2;buy++){
    //             for(int cnt=1;cnt<=2;cnt++){
    //                 int profit;
    //                 if(buy==1){
    //                     profit=Math.max(-prices[i]+dp[i+1][0][cnt],0+dp[i+1][1][cnt]);
    //                 }else{
    //                     profit=Math.max(prices[i]+dp[i+1][1][cnt-1],0+dp[i+1][0][cnt]);
    //                 }

    //                 dp[i][buy][cnt]=profit;
    //             }
    //         }
    //     }
    //     return dp[0][1][2];
    // }
}