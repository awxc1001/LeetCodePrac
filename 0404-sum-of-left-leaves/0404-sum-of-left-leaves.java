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
    int leftSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return leftSum;
        
    }
    
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        //check if this node has left leaf
        //need to also check if it actually has leftnode with val
    
        traverse(root.left);
        traverse(root.right);
            if( root.left != null &&
            root.left.left == null && 
           root.left.right == null){
            leftSum += root.left.val;
        }
        
    }
    
}