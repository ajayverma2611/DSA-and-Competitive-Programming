class Solution {

    public void dfs(int i, int j, int n, int m, char[][] grid, int[][] vis){

        vis[i][j]=1;

        int d1[]={0,0,1,-1};
        int d2[]={-1,1,0,0};

        for(int k=0;k<4;k++){
            int ni=i+d1[k];
            int nj=j+d2[k];

            if(ni<0 || nj<0 || ni>=n || nj>=m || grid[ni][nj]=='0'|| vis[ni][nj]==1){
                continue;
            }

            dfs(ni,nj,n,m,grid,vis);
        }

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int vis[][] = new int[n][m];
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    cnt++;
                    dfs(i,j,n,m,grid,vis);
                }
            }
        }

        return cnt;
    }
}