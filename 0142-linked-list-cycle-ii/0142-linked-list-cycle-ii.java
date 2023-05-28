/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        
        ListNode fast = head;
        ListNode slow = head;
        
      

        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(slow == fast){
                break;
            }
        }
        
        
         //If there is no cycle after the above traversel, break did not reach
        if (fast == null || fast.next == null) {
            return null;
        }
        
        //find intersection, let one pointer go to head and move until fast and slow match
        slow = head;
        while( slow != fast ){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}