class Solution {
    public int[] findOrder(int numCourses, int[][] grid) {
        int[] ans=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<grid.length;i++){
            adj.get(grid[i][1]).add(grid[i][0]);
        }

        int inOrder[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                inOrder[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<inOrder.length;i++){
            if(inOrder[i]==0){
                q.offer(i);
            }
        } 

        int ind=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[ind]=node;
            ind++;

            for(int it:adj.get(node)){
                inOrder[it]--;

                if(inOrder[it]==0){
                    q.offer(it);
                }
            }
        }

        return ind==numCourses?ans:new int[0];
    }
}