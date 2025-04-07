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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode temp=root;
        while(temp != null){
            if(val < temp.val &&  temp.left == null){
                temp.left=new TreeNode(val);
                return root;
            }
            if(val > temp.val && temp.right == null){
                temp.right=new TreeNode(val);
                return root;
            }
            if(val > temp.val ){
                temp=temp.right;
            }else{
                temp=temp.left;
            }
        }

        return root;
    }
}