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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        
        //fill the root node in queue, we will use queue to fill each level nodes
        Queue<TreeNode> q = new LinkedList<>();
          q.offer(root);
        
        while(!q.isEmpty()){
            
            int sz = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            
            //loop each current level node stored in the queue
            for (int i = 0; i < sz; i++  ){
                //take out and add to level
                TreeNode node = q.poll();
                //integer value, not the node
                level.addLast(node.val);
                
                //fill the queue with next level
                if(node.left != null){
                    q.offer(node.left);
                }
                 if(node.right != null){
                    q.offer(node.right);
                }
            }
            
            res.addLast(level);
            
        }
        
        return res;
    }
}