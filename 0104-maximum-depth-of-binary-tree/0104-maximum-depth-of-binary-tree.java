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
    
    int depth = 0;
    int result = 0;
    
    
    public int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }
    
    //traverse recusiverly
    public void traverse(TreeNode root){
        
        if(root == null){
          return ;
        }
        
       //any root exisit, should increase depth
       depth ++;
       result = Math.max(result, depth);
       
        
       traverse(root.left);
       traverse(root.right);
       //after check there is no more left or right child, go up to the root node level 
       depth --;
    }
}