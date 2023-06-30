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
    public int maxDepth(TreeNode root) {
        
        //what should a currentNode do
        //retrive the max height from its left and right
        //making sure itself is not null
        if(root == null){
            return 0; //indicate no depth
        }
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        //now as the root node, at its level to the deeper height
        return 1+Math.max(leftHeight,rightHeight);
        
    }
}