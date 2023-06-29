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
    public TreeNode invertTree(TreeNode root) {
        
        traverse(root);
        return root;
        
    }
    
    public void traverse(TreeNode root) {
        
        if(root == null){
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode temp = root.left;
        //swap
        root.left = root.right;
        root.right = temp;
        
        traverse(root.left);
        traverse(root.right);
        
    }
}