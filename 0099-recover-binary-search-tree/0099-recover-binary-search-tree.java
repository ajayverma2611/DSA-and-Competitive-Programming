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

    //============================== Bruteforce =======================================================
    // ArrayList<Integer> inorder = new ArrayList<>();
    // int i=0;
    // public void inOd(TreeNode root){
    //     if(root == null){
    //         return;
    //     }

    //     inOd(root.left);
    //     inorder.add(root.val);
    //     inOd(root.right);
    // }
    // public void inOdtoCorrect(TreeNode root){
    //     if(root == null ){
    //         return ;
    //     }

    //     inOdtoCorrect(root.left);
    //     if(root.val != inorder.get(i)){
    //         root.val=inorder.get(i);
    //     }
    //     i++;
    //     inOdtoCorrect(root.right);
    // }
    // public void recoverTree(TreeNode root) {    
    //     inOd(root);
    //     Collections.sort(inorder);
    //     inOdtoCorrect(root);
    // }


    //============================================= Optimal =====================================
    
    TreeNode first;
    TreeNode last;
    TreeNode middle;
    TreeNode prev;

    public void inOder(TreeNode root){
        if(root == null ){
            return ;
        }

        inOder(root.left);

        if(root.val<prev.val){

            if(first==null){
                first=prev;
                middle=root;
            }else{
                last=root;
            }
        }
        prev=root;

        inOder(root.right);

    }
    public void recoverTree(TreeNode root) {    
        first=last=middle=null;
        prev=new TreeNode(Integer.MIN_VALUE);

        inOder(root);

        if(first!=null && last!=null){
            int tmp=first.val;
            first.val=last.val;
            last.val=tmp;
        }else{
            int tmp=first.val;
            first.val=middle.val;
            middle.val=tmp;
        }
    }
}