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
    
    boolean found = false;
    int calSum = 0;
        
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        traverse(root, targetSum);
        return found;
    }
    
    public void traverse(TreeNode root, int targetSum){
        
        if (root == null){
            return;
        }
        
        //before current node going down
        calSum += root.val;
        //check if it node is leaf
        if(root.left == null && root.right == null){
            //check if targetSum
            if(calSum == targetSum){
                found = true;
            }
        }
        
        //go down 
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        //reverse back
        calSum -= root.val;   
    }
}