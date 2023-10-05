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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        
        //must insert root first, then we start check the queue for each level
        //make sure q store TreeNode not its value
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            //record each level with integer list 
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            //record and add next level
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                level.add(cur.val);
                //add left and right
                //make sure not null
                if(cur.left != null){
                    q.offer(cur.left);
                } 
                if(cur.right != null){
                    q.offer(cur.right);
                } 
            }
            //now add each level to res but in reverse order
            res.addFirst(level);
        }
        return res;
    }
}