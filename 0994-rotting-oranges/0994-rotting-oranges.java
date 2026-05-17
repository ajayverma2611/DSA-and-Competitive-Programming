class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int vis[][]= new int[n][m];
        Queue<Pair<Pair<Integer, Integer>,Integer>> q = new LinkedList<>();
        
        int fresh =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(new Pair(i,j),0));
                    vis[i][j]=1;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        int ans = 0;

        int cnt=0;
        while(!q.isEmpty()){
            int r = q.peek().getKey().getKey();
            int c = q.peek().getKey().getValue();
            int l = q.peek().getValue();
            q.poll();
            ans =Math.max(ans , l);

            for(int i=0;i<4;i++){
                int nr=r+dx[i];
                int nc=c+dy[i];

                if(nr <0 || nr>=n || nc<0 || nc>=m || grid[nr][nc] == 0|| grid[nr][nc] == 2 || vis[nr][nc]==1){
                    continue;
                }

                q.offer(new Pair(new Pair(nr,nc),l+1));
                cnt++;
                vis[nr][nc]=1;

            }
        }

        if(fresh != cnt){
            return -1;
        }

        return ans;
    }
}