class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int vis[][] = new int[n][m];
        int ans[][] = new int[n][m];

       Queue<Pair<Pair<Integer,Integer>,Integer>> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair<>(new Pair<>(i,j),0));
                }
            }
        }

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(!q.isEmpty()){

            int r = q.peek().getKey().getKey();
            int c = q.peek().getKey().getValue();
            int val = q.peek().getValue();

            q.poll();

            if(mat[r][c]==1){
                ans[r][c]=val;
            }

            for(int i=0;i<4;i++){
                int nr = r+dx[i];
                int nc = c+dy[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc] == 0){
                    q.add(new Pair<>(new Pair<>(nr,nc),val+1));
                    vis[nr][nc]=1;
                }
            }
        }

        return ans;
    }
}