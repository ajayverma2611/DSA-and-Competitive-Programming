class Solution {
    int dirs[][][] = {
        {},
        {{0,1},{0,-1}},
        {{1,0},{-1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };

    public boolean isCon(int i, int j , int pi, int pj, int[][] grid){
        for(int d[] : dirs[grid[i][j]]){
            if(d[0]==pi && d[1]==pj){
                return true;
            }
        }

        return false;
    }
    public boolean dfs(int i, int j,int[][] grid, int vis[][], int n , int m){
        if(i==n-1 && j==m-1){
            return true;
        }

        vis[i][j]=1;

        for(int d[]: dirs[grid[i][j]]){
            int ni=i+d[0];
            int nj=j+d[1];

            if(ni<0 || ni>=n || nj<0 || nj>=m || vis[ni][nj]==1) continue;

            if(isCon(ni, nj,-d[0],-d[1],grid)){
                if(dfs(ni,nj,grid,vis,n,m)){
                    return true;
                }
            }
        }

        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        return dfs(0,0,grid, vis,n,m);  
    }
}