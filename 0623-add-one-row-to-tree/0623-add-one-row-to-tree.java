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
    int dep = 0;
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //The number of nodes in the tree is in the range [1, 104].
    //the depth of the tree is in the range [1, 104].
        if(depth == 1){
    //if depth == 1 that means there is no depth depth - 1 at all, then create a tree node  with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        traverse(root,val,depth);
        return root;
    }
    
    public void traverse(TreeNode root, int val, int depth){
    if(root == null){
        return;
    }

    //entering a node
    dep++;

    if(dep == depth-1){
        //original left and right subtree
       TreeNode left = root.left;
       TreeNode right = root.right;
       //assign new ones 
       root.left = new TreeNode(val);
       root.right = new TreeNode(val);  
       root.left.left = left;
       root.right.right = right;
       //reach depth
       //No need to reset dep here. dep should decrease as we go back to upper level.
    } else {
       //traverse
       traverse(root.left,val,depth);
       traverse(root.right,val,depth);
    }
    //postOrder, go back to upper level, so decrease dep
    dep--;
}

    

}