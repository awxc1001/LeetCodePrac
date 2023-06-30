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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //recursion approach
        //current node should be doing the following
        //fistly we cover all the base conditon checks for this node
        //if itself is null return false
        //if itself is a leaftNode, we need to check if it equals a targetvalue
        //that targetValue should reduce from its parent root val
        //now check if this node meet the targetValue, return true recursively
        //if not return false, end the recursion
        
        if(root == null){
            return false;
        }
        
        
        
        if(root.left ==null && root.right == null && root.val == targetSum){
            return true;
        }
        
      int targetSub = targetSum - root.val;
        
     return hasPathSum(root.left, targetSub) || hasPathSum(root.right, targetSub);
       
        
    }
}