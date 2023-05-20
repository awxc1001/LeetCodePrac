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
    
    LinkedList<String> path = new LinkedList<>();
    LinkedList<String> res = new LinkedList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        traverse(root);
        return res;
            
    }
    
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        
        //preorder
        //convert value to string
        path.addLast(root.val + "");
        
        traverse(root.left);
        traverse(root.right);
        
        //if leafNode, this can postOrder or preOrder, preOrder maybe faster? 
        if(root.left == null && root.right == null){
            // add to result
            res.addLast(String.join("->",path));
            // always remove the path
            path.removeLast();
            return;
        }
        path.removeLast();
    }
}