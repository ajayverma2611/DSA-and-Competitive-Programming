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
    int preorderIndx=0;
    public int findInorder(int target , int[] inorder , int left , int right){
        for(int i=left;i<=right;i++){
            if(inorder[i]==target){
                return i;
            }
        }

        return -1;
    }
    public TreeNode solve(TreeNode root ,int left, int right , int[] preorder , int[] inorder,int n){
        if(preorderIndx == n){
            return null;
        }

        
        int indx=findInorder(preorder[preorderIndx],inorder,left ,right);

        if(indx==-1){
            return null;
        }

        TreeNode temp=new TreeNode(preorder[preorderIndx++]);
        root=temp;

        root.left=solve(root.left, left, indx-1,preorder, inorder,n);
        root.right=solve(root.right,indx+1,right,preorder, inorder,n);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        TreeNode root=null;
        return solve(root,0,n-1,preorder, inorder,n);
    }
}