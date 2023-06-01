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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        
        HashMap<Integer, Integer> counts = new HashMap<>();
        
        ListNode fast = head;
        
        while(fast != null){
            counts.put(fast.val,counts.getOrDefault(fast.val, 0)+1);
            fast = fast.next;
        }
        
        //now we have our table. loop again to remove more than 1 counts
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode start = dummy;
        
        while( start != null){
            
            ListNode unique = start.next;
            //start checking
            while( unique != null && counts.get(unique.val) > 1){
                //skip it, we go to a node that is unique
                unique = unique.next;
            }
            
            //now append and keep going
            start.next = unique;
            start = start.next;
        }
        
        return dummy.next;
    }
}