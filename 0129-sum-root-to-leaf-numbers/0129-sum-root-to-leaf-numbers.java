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
    
    StringBuilder path = new StringBuilder();
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        
        traverse(root);
        return sum;
    }
    
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        // add value to path Stringbuilder, auto conver to String val;
        path.append(root.val);
        
        // if leafNode
        if( root.left == null && root.right == null ){
            int pathVal = Integer.parseInt(path.toString());
            sum += pathVal;
        }
        
        traverse(root.left);
        traverse(root.right);
        
        //remove each node after processing, postorder
        path.deleteCharAt(path.length() - 1);
    }
}