class Solution {
    //    public int solve(int ind, int amount, int coin[], int dp[][]) {
       
    //     if (ind == 0) {
    //         if (amount % coin[ind] == 0) {
    //             return amount / coin[ind];   
    //         }
    //         return Integer.MAX_VALUE; 
    //     }

    //     if (dp[ind][amount] != -1) {
    //         return dp[ind][amount];
    //     }

    
    //     int skip = solve(ind - 1, amount, coin, dp);

       
    //     int take = Integer.MAX_VALUE;
    //     if (coin[ind] <= amount) {
    //         int result = solve(ind, amount - coin[ind], coin, dp);
    //         if (result != Integer.MAX_VALUE) {
    //             take = 1 + result;  
    //         }
    //     }

        
    //     return dp[ind][amount] = Math.min(take, skip);
    // }

    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
        
        
    //     int dp[][] = new int[n][amount + 1];
    //     for (int[] row : dp) {
    //         Arrays.fill(row, -1);
    //     }

    //     int ans = solve(n - 1, amount, coins, dp);

    //     return ans == Integer.MAX_VALUE ? -1 : ans;
    // }

    //=================================== TAbulation ===================================

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        
        int dp[][] = new int[n][amount + 1];

        for(int i=0;i<=amount;i++){
            if (i % coins[0] == 0) {
                dp[0][i]=i/coins[0];   
            }else{
                dp[0][i]=Integer.MAX_VALUE; 
            }
        }

        for(int i=1;i<n;i++){
            for(int a=0;a<=amount;a++){
                int skip=dp[i-1][a];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=a){
                    int res=dp[i][a-coins[i]];
                    if(res!=Integer.MAX_VALUE){
                        take=1+res;
                    }
                }


                dp[i][a]=Math.min(take,skip);
            }
        }

        int ans = dp[n-1][amount];

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}