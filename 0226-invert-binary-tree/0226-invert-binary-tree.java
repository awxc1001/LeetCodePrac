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
    
    public void traverse(TreeNode root){
        
        if(root == null){
            return;
        }
        
        traverse(root.left);
        traverse(root.right);
        
        //any part is fine, because null switching dont matter
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;        
    }
}