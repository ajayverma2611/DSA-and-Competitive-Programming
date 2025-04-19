class Solution {
    //========================================= Memoization =====================================
    // public int solve(int i,int j, int[][] grid, int[][] dp){
    //     if(i==0 && j==0){
    //         return 1;
    //     }

    //     if(i<0 || j<0 || grid[i][j]==1){
    //         return 0;
    //     }

    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     int left=solve(i,j-1,grid,dp);
    //     int up=solve(i-1,j,grid,dp);

    //     return dp[i][j]=left+up;
    // }
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int n=obstacleGrid.length;
    //     int m=obstacleGrid[0].length;
    //     int dp[][]=new int[n][m];
    //     for(int r[]:dp){
    //         Arrays.fill(r,-1);
    //     }
    //     return solve(n-1, m-1, obstacleGrid,dp);
    // }


    //================================== Tabulation ===============================================
    
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int n=obstacleGrid.length;
    //     int m=obstacleGrid[0].length;
    //     int dp[][]=new int[n][m];
    //     dp[0][0]=1;

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(i==0 && j==0){
    //                 dp[i][j]=1;
    //             }else{
    //                 int up=0;
    //                 int left=0;
    //                 if(obstacleGrid[i][j]==1){
    //                     dp[i][j]=0;
    //                     continue;
    //                 }

    //                 if(i>0){
    //                     up=dp[i-1][j];
    //                 }
    //                 if(j>0){
    //                     left=dp[i][j-1];
    //                 }

    //                 dp[i][j]=up+left;
    //             }
    //         }
    //     }

    //     return dp[n-1][m-1];
    // }



    //=============================== SpaceOptimization =============================================
     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[]=new int[m];
        
        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0 && obstacleGrid[i][j]==0){
                    temp[j]=1;
                }else{
                    int up=0;
                    int left=0;
                    if(obstacleGrid[i][j]==1){
                        temp[j]=0;
                        continue;
                    }

                    if(i>0){
                        up=dp[j];
                    }
                    if(j>0){
                        left=temp[j-1];
                    }

                    temp[j]=up+left;
                }
            }

            dp=temp;
        }

        return dp[m-1];
    }
}