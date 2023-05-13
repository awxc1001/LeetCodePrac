/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        //this one just look for if head can fit any side of the tree
        
         if (root == null) return false;
        
        //start from root, preorder compare, if found matched check if all match
        if(root.val == head.val){
            if(isSame(head, root)){
                return true;
            }
        }
        
        return  isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    public boolean isSame(ListNode head, TreeNode root) {
        // this one look if left and right can match each node from head
        
        //end of linked list return true
        if(head == null){
            return true;
        }
        // end of tree
        if(root == null){
           return false; 
        }
        
        //preorder, value no match no need compare further
        if(head.val != root.val ){
            return false;
        }
        
        //lined list is one direction, either side can satisfy
        return  isSame(head.next, root.left) || isSame(head.next, root.right);
    }
}