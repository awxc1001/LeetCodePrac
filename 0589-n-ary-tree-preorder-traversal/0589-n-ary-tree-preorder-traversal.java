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
    
    List<Integer> preOrderList = new ArrayList<>();
    List<Integer> postOrderList = new ArrayList<>();
    
    public List<Integer> preorder(Node root) {
        
        traverse(root);
        
        return preOrderList;
    }
    
    public void traverse(  Node root ){
        
        if(root == null){
            return;
        }
        
        //PreOrder action
        preOrderList.add(root.val);
        
        //no inOrder for N-ary Tree because no mid point like binary treee
        for(Node child: root.children){
            traverse(child);
        }
        
        //PreOrder action
        postOrderList.add(root.val);
        
    }
}