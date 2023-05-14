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
    
    int sum = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        
//      The number of nodes in the tree is in the range [1, 104].
//       1 <= Node.val <= 100
       
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
        
      while( !q.isEmpty() ){
          int sz = q.size();
          // need to reset the sum incase one side has leave but other side is keep going
          sum = 0;
          for(int i = 0; i < sz; i ++){
              TreeNode curr = q.poll();
              
              //adding leaf nodes only
              if( curr.left == null && curr.right == null){
                  sum += curr.val;
              }
              
              if(curr.left != null){
                  q.offer(curr.left);
              }
              if(curr.right != null){
                  q.offer(curr.right);
              }
          }
      } 
        
        return sum;
    }
    
}