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
    public int findBottomLeftValue(TreeNode root) {
        
        //The number of nodes in the tree is in the range [1, 104].
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int mostLeft = root.val;
        
        while(!q.isEmpty()){
            

         // we just want the the most left, which is the first in the q;
         mostLeft = q.peek().val;   
         
         // take out the remaining nodes   
         int size = q.size();
            
            for(int i =0; i < size; i++){
                TreeNode curr = q.poll();
              
            // put the next level nodes at the tail
            if(curr.left != null){
               q.offer(curr.left);
           } 
              if(curr.right != null){
               q.offer(curr.right);
           }      
        }
           
        }
        
        return mostLeft;
    }
}