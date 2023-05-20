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
    
    //bfs
    public List<Integer> rightSideView(TreeNode root) {
        
        LinkedList<Integer> res = new LinkedList<>();
        
        //return empty list not null for this questions
        if(root == null){
            return res;
        }
        
        
        //the q to store each level nodes
        Queue<TreeNode> q = new LinkedList<>();
        
        //add root
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int sz = q.size();
            //we want top of the queue to be always the most right node of each level
            TreeNode mostRight = q.peek();
            
            for(int i =0; i < sz; i ++){
                //controlling the next level q
                TreeNode cur = q.poll();
                //add right first
                if(cur.right != null){
                    q.offer(cur.right);
                }
                if(cur.left  != null){
                    q.offer(cur.left);
                }
            }
             
            //add Mostright of each level to res
            res.addLast(mostRight.val);
        }
        
        return res;
    }
}