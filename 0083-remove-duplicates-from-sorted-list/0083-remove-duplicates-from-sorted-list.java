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
        // ListNode dummy = new ListNode(-1);
        // ListNode dp = dummy;
        // dp.next = head;
        
        if(head == null){
            return null;
        }
        
        ListNode fp = head;
        ListNode sp = head;
        
        //fp move by one node no matter what
        while(fp != null){
            
//if fp val does not equal slow p val, then it is a unique value node
            // remember its val!
            if( fp.val != sp.val){
                //only link to next that is unqiue, other nodes even linked is not linked from head anymore
                sp.next = fp;
                sp = sp.next;
            }
            fp = fp.next;
        }
        //final node should be null incase of duplicate nodes
        sp.next = null;
        return head;
    }
}