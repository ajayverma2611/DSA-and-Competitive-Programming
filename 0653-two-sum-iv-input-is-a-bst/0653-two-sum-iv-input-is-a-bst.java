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
    public ArrayList<Integer> inorder= new ArrayList<>();

    public void InOd(TreeNode root){
        if(root == null){
            return;
        }

        InOd(root.left);
        inorder.add(root.val);
        InOd(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }

        InOd(root);

        int i=0;
        int j=inorder.size()-1;
        int sum=0;
        while(i<j){
            sum=inorder.get(i)+inorder.get(j);
            if(sum==k){
                return true;
            }else if(sum<k){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }
}