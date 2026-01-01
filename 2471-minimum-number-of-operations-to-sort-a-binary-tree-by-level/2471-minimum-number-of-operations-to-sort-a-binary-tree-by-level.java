/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void solve(ArrayList<Integer> arr , int cnt[]){
        int n= arr.size();
        for(int i=0;i<n;i++){
            int mini=arr.get(i);
            int ind=i;
            
            for(int j=i+1;j<n;j++){
                if(arr.get(j)<mini){
                    mini=arr.get(j);
                    ind=j;
                }
            }

            if(ind!=i){
                cnt[0]++;
                int temp=arr.get(i);
                arr.set(i,arr.get(ind));
                arr.set(ind,temp);
            }
        }
    }
    public int minimumOperations(TreeNode root) {

        ArrayList<ArrayList<Integer>> arr1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>();
        int ans = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            ArrayList<Integer> a = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();

                if (tmp.left != null) {
                    q.add(tmp.left);
                    a.add(tmp.left.val);
                }

                if (tmp.right != null) {
                    q.add(tmp.right);
                    a.add(tmp.right.val);
                }
            }

            arr1.add(new ArrayList<>(a)); // important copy
            arr2.add(new ArrayList<>(a));
        }

        int n = arr1.size();

       int cnt[]=new int[1];
       cnt[0]=1;
        for (int i = 0; i < n; i++) {
            solve(arr1.get(i),cnt);
        }

        return cnt[0]-1;
    }

}