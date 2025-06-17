class Solution {

    public int solve(int i , int j , List<List<Integer>> tri,int[][] dp){
        if(i==0 && j==0){
            return tri.get(i).get(j);
        }

        if(i<0 || j<0 || j>=tri.get(i).size()){
            return Integer.MAX_VALUE/2;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int justUp=tri.get(i).get(j)+solve(i-1,j,tri,dp);
        int leftUp=tri.get(i).get(j)+solve(i-1,j-1,tri,dp);

        return dp[i][j]=Math.min(justUp,leftUp);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.get(n-1).size();
        int mini=Integer.MAX_VALUE;
        int dp[][]=new int[n][m];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }

        for(int i=m-1;i>=0;i--){
            mini=Math.min(mini,solve(n-1,i,triangle,dp));
        }

        return mini;

    }
}