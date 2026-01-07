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
    public long sum=0;
    long ans =Long.MIN_VALUE;
    public void solve(TreeNode root){
        if(root == null){
            return;
        }

        solve(root.left);
        solve(root.right);

        long mul = sum-root.val;
        ans=Math.max(ans,root.val*mul);
    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }

        sum+=root.val;
        helper(root.left);
        helper(root.right);


        if(root.left!=null){
            root.val=root.val+root.left.val;
        }

        if(root.right!=null){
            root.val=root.val+root.right.val;
        }

        System.out.println(root.val); 
    }
    public int maxProduct(TreeNode root) {
        
        helper(root);
        solve(root);
        System.out.println(sum);
        System.out.println(ans%100000007);
        ans=ans%1000000007;
        return (int)ans;

    }
}