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
    String res = null;
    
    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }
    
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        //process when reaching a left node
        if(root.left == null && root.right == null){
            //still add the node like preorder
            path.append((char) ('a' + root.val));
            //left to root reverse
            path.reverse();
            
            String pathString = path.toString();
            if( res == null || res.compareTo(pathString) > 0){
                res = pathString;
            }
            
            // done comparing and processing, back to normal preorder
            path.reverse();
            path.deleteCharAt( path.length() - 1);
                   
        }
        
        //add node to path preorder
        path.append((char) ('a' + root.val));
        
        traverse(root.left);
        traverse(root.right);
        
        //remove node postOrder
        path.deleteCharAt( path.length() - 1);
    }
}