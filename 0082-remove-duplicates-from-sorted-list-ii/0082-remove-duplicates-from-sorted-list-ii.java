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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        ListNode fast = head;
        dummy.next = head;
        ListNode slow = dummy;
        
        while( fast != null){
            
            // if there is a duplicate
            if( fast.next != null && fast.next.val == fast.val ){
                //move fast to the last node of duplicate 
                while( fast.next != null && fast.next.val == fast.val ){
                    fast = fast.next;
                }
            
            //now move fast to the next non-duplicate node
            fast = fast.next;
                
            if( fast == null ){
                slow.next = null;
            }   
        }else{ // if not null, apply the non-duplicate to the slow
            slow.next = fast;
            slow = slow.next;
            fast = fast.next;      
        }
       
}
         return dummy.next;
}
}