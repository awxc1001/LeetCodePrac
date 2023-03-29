/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        //check if these two pointers will point to the same node after each chain 
        //finish eg. a1 to c3 then b1 to c3, so two pointer walk the same length nodes
        while( p1 != p2){
            //if p1 finish, got to headB walk again
            if(p1 == null){
                p1 = headB;
            }else{
                p1 = p1.next;
            }
            ////if p2 finish, got to headA walk again
            if(p2 == null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
        // return either p1 or p2 since they will point same node if intersects
        return p2;
    }
}