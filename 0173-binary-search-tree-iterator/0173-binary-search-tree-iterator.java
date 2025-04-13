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
class BSTIterator {

    ArrayList<Integer> inorder= new ArrayList<>();
    int ind;
    public void Inod(TreeNode root){
        if(root == null){
            return;
        }

        Inod(root.left);
        inorder.add(root.val);
        Inod(root.right);
        
    }

    public BSTIterator(TreeNode root) {
        Inod(root);
        ind=-1;

    }
    
    public int next() {
        if(ind==-1){
            ind=0;
            return inorder.get(ind);
        }else{
            ind++;
            return inorder.get(ind);
        }
    }
    
    public boolean hasNext() {
        if(ind+1<inorder.size()){
            return true;
        }
        return false;  
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */