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
     
    //Constraints:

    // The number of nodes in the tree is in the range [1, 3 * 104].
    // -3 * 104 <= Node.val <= 3 * 104
    
     int maxLen = 0;
    
    public int longestConsecutive(TreeNode root) {
        // the trick is to use parentVal;
        int parentVal = Integer.MIN_VALUE;
        traverse(root, 1, parentVal);
        return maxLen;
    }
    
    public void traverse(TreeNode root, int curLength, int parentVal){
        if(root == null){
            return;
        }
        
        //consecutive or reset length, length variable is shared on both subtree
        if(parentVal+1 == root.val){
            curLength ++;
        }else{
            curLength = 1;
        }
        //left length will be overwriteen by right
        // so always record
        maxLen = Math.max(curLength,maxLen);
        
        traverse(root.left, curLength, root.val);
        traverse(root.right,curLength, root.val);
      
    }
}