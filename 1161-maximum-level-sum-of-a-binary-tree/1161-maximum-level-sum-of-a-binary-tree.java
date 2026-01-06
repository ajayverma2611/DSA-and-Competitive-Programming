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

    ArrayList<Integer> tmp = new ArrayList<>();
    public void solve(TreeNode root, int l){
        if(root == null){
            return;
        }


        if(root.left != null && tmp.size() > l+1){
            tmp.set(l+1,tmp.get(l+1)+root.left.val);
        }else if(root.left != null){
            tmp.add(root.left.val);
        }

        solve(root.left,l+1);


        if(root.right != null && tmp.size()>l+1){
            tmp.set(l+1,tmp.get(l+1)+root.right.val);
        }else if(root.right != null){
            tmp.add(root.right.val);
        }


        solve(root.right,l+1);
        
    }

    public int maxLevelSum(TreeNode root) {
        tmp.add(root.val);
        solve(root,0);
        int ans = 0;
        int maxi=Integer.MIN_VALUE;

        int n=tmp.size();
        for(int i=0;i<n;i++){
            System.out.println(tmp.get(i));
            if(tmp.get(i)>maxi){
                maxi=tmp.get(i);
                ans =i+1;
            }
        }

        return ans;
    }
}