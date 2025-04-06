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
    // List<Integer> ans=new ArrayList<Integer>();

    // public void inorder(TreeNode root){
    //     if(root == null){
    //         return;
    //     }

    //     inorder(root.left);
    //     ans.add(root.val);
    //     inorder(root.right);
    // }
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     inorder(root);
    //     return ans;
    // }


    //============================= Morris InorderTraversal ==============================

    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left == null){
                ans.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }

                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }else{
                    prev.right=null;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }
        }

        return ans;

    }
}