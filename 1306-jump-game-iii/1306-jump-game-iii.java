class Solution {
    public boolean solve(int i, int[] arr,int[] vis, int n){
        if(i<0 || i>= n){
            return false;
        }
        if(vis[i]==1){
            return false;
        }

        if(arr[i]==0){
            return true;
        }

        vis[i]=1;
        boolean right = solve(i+arr[i],arr,vis,n);
        boolean left = solve(i-arr[i],arr,vis,n);


        return left||right;
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int vis[]= new int[n];
        return solve(start,arr,vis,n);
    }
}