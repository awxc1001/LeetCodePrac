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
    public void flatten(TreeNode root) {
        
        if ( root == null ){
            return;
        }

        //start from each sub tree
        flatten(root.left);
        flatten(root.right);
        
        //record and assign left to right first
        TreeNode originalLeft = root.left;
        TreeNode originalRight = root.right;

        root.right = originalLeft;
        root.left = null;
        
        //go down to the assigned new right and append the oringal right
        TreeNode start = root;
        while(start.right != null ){
            start = start.right;
        }
        start.right = originalRight;
    }
}