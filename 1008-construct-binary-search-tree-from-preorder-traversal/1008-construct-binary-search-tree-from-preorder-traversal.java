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
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode solve(int[] pre, int ub , int[] i){
        if(i[0]==pre.length || pre[i[0]]>ub){
            return null;
        }

        TreeNode node = new TreeNode(pre[i[0]++]);
        node.left=solve(pre,node.val,i);
        node.right=solve(pre,ub,i);

        return node;
    }
}