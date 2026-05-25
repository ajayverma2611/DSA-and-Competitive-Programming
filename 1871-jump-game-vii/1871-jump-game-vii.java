class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();

        int vis[] = new int[n];
        vis[0]=1;
        q.add(0);
        int far =0;

        while(!q.isEmpty()){
            int i = q.peek();
            q.poll();

            if(i==n-1){
                return true;
            }

            for(int j=Math.max(i+minJump,far) ; j<n && j<=i+maxJump ;j++){
                if(s.charAt(j)=='0' && vis[j]==0){
                    vis[j]=1;
                    q.add(j);
                }
            }

            far=i+maxJump+1;
        }

        return false;
    }
}