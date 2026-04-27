class Solution {
    public boolean dfs(int i, int j, int pari, int parj,
                       char[][] grid, int[][] vis) {

        vis[i][j] = 1;

        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        for(int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length)
                continue;

            if(grid[ni][nj] != grid[i][j])
                continue;

            if(ni == pari && nj == parj)
                continue;

            if(vis[ni][nj] == 1)
                return true;

            if(dfs(ni, nj, i, j, grid, vis))
                return true;
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0) {
                    if(dfs(i, j, -1, -1, grid, vis))
                        return true;
                }
            }
        }
        return false;
    }
}