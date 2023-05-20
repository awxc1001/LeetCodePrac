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
    
           //The number of nodes in the tree is in the range [1, 104].
        // -100 <= Node.val <= 100
        int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
   
        maxDepthleftRight(root);
        return maxDiameter;
        
    }
    
    public int maxDepthleftRight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = maxDepthleftRight(root.left);
        int rightMax = maxDepthleftRight(root.right);
        int diameter = leftMax+rightMax;
        maxDiameter = Math.max(diameter, maxDiameter);    
        
        return  1+Math.max(leftMax, rightMax);
        
        
    }
}