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
    public int maxLevelSum(TreeNode root) {
        
        
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        // The number of nodes in the tree is in the range [1, 104].
        int result = root.val;
        
        int depth = 1;
        int maxLevel = depth;
        
        while(!q.isEmpty()){
            
            int levelSum = 0;
            int sz = q.size();
            
            for(int i =0; i < sz; i++){
                TreeNode curr = q.poll();
                levelSum += curr.val;
                
                if(curr.left != null){
                    q.offer(curr.left);
                }
                 if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            
            // result = Math.max(result, levelSum);
            //store the bigger level 
            if(levelSum > result){
                result = levelSum;
                maxLevel = depth;
            }
            
            depth++;
        }
        
        return maxLevel;
    }
}