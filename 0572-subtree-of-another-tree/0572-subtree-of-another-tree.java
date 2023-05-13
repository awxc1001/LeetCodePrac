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
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null){
            return false;
        }
        //preorder because as long its not fit, no need go deeper
        if(sameStructure(root,subRoot)){
            return true;
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    
public boolean sameStructure(TreeNode root, TreeNode subRoot) {
    
    //preorder compare
    //null pointer excpetion error if we dont check null of both node first
    if (root == null && subRoot == null) {
        return true;
    }
    
    if (root == null || subRoot == null) {
        return false;
    }
    
    if (root.val != subRoot.val) {
        return false;
    }
    
    // pattern must all match since we are already comparing subtrees in this function
    return sameStructure(root.left, subRoot.left) && sameStructure(root.right, subRoot.right);
}

}