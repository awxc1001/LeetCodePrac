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
    int result = 0;
    int path = 0;

    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // Preorder record
        path = (path << 1) | root.val;

        // Hits leaf node, modify result
        if (root.left == null && root.right == null) {
            // Update result
            result += path;
        } else {
            traverse(root.left);
            traverse(root.right);
        }
        // Postorder remove
        path = path >> 1;
    }
}

