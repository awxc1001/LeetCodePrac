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
    public ListNode reverseList(ListNode head) {
        
        // ListNode dummy = new ListNode(-1);
        // dummy.next = head;
        
        // have a null first not dummy beacause impossible to cut down tail
        ListNode prev = null;  
        
        ListNode p = head;
        
        while(p != null){
            
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        
        //p is now null with .next, so return prev which assign the tail
        return prev;
    }
}