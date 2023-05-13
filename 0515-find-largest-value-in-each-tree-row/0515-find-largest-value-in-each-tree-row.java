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
    public List<Integer> largestValues(TreeNode root) {
        
        LinkedList<Integer> res = new LinkedList<>();
        //dont forget edge cases which is the base case for recursion
        if(root == null){
            return res;
        }
        
        
        
        //start initial condition
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int sz = q.size();
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < sz; i++){
                //update the max for each level
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                
                //next level filling
                if(node.left != null){
                    q.addLast(node.left);
                }
                 if(node.right != null){
                    q.addLast(node.right);
                }
            }
            
            //add the max of each level to res
            res.addLast(max);
        }
    
        return res;
    }
}