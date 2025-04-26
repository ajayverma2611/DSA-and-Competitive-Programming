class Solution {
  
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int visit[][]=new int[n][m];
        int ans[][]=new int[n][m];

        Queue<Pair<Pair<Integer,Integer>,Integer>> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair<>(new Pair<>(i,j),0));
                    visit[i][j]=1;
                }
            }
        }


        int[] drow=new int[]{0,0,1,-1};
        int[] dcol=new int[]{1,-1,0,0};

        while(!q.isEmpty()){
            int r=q.peek().getKey().getKey();
            int c=q.peek().getKey().getValue();
            int s=q.peek().getValue();
            q.poll();
            ans[r][c]=s;

            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visit[nrow][ncol]==0 &&
                mat[nrow][ncol]==1){
                    q.offer(new Pair<>(new Pair<>(nrow,ncol),s+1));
                    visit[nrow][ncol]=1;
                }
                
            }
        }

        return ans;
    }
}