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
   public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        
        // When left or right subtree is missing, return the depth of the other side directly
        if (root.left == null) {
            return minRight + 1;
        }
        if (root.right == null) {
            return minLeft + 1;
        }
        
        // When both subtrees exist, return the smaller one
        return Math.min(minLeft, minRight) + 1;
    }
}