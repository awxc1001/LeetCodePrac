/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    int depth = 0;
    int result = 0;
    
    public int maxDepth(Node root) {
        
        traverse(root);
        
        return result;
       
    }
    
     public void traverse(Node root ){
         
         if(root == null){
             return;
         }
         
         depth ++;
         
         result = Math.max(depth, result);
         
         for(Node child: root.children){
             traverse(child);
         }
         
         depth --;
         
     }
    
}