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
    public List<Double> averageOfLevels(TreeNode root) {
        
        LinkedList<Double> avgValList = new LinkedList<>();
        if(root == null){
            return avgValList;
        }
        
        //BFS queue for the each node of each level
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
       
        
        while(!q.isEmpty()){
            // size for looping
            int sz = q.size(); 
             //record sum for only each level!
            double levelSum =0;
            int totalNodes = 0;
            
            for(int i=0; i<sz; i++){
                TreeNode cur = q.poll();
                levelSum += cur.val;
                totalNodes++;
                
                if(cur.left != null){
                    q.offer(cur.left);
                }if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            //after each level precessing
            avgValList.addLast(levelSum*1.0/totalNodes);
        }
        return avgValList;
        
    }
}