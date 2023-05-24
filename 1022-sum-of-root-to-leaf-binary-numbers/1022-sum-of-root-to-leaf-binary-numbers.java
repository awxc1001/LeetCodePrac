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
    
//     Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// Node.val is 0 or 1.
    int result = 0;
    int path = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return result;
    }
    
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        
        //hits leaf node, modify result
        if( root.left == null && root.right == null){
            result += path << 1 | root.val;
            // result += path;
            return;
        }
        
        //preorder record
        path = path << 1 | root.val;
        traverse(root.left);
        traverse(root.right);
        //postorder remove
        path = path >> 1;
    }
}