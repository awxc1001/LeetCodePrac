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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        
        //need to check the first node, use dummy and pre
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        
        while(curr != null){
            //check   -1-1-1-2-3
            if(curr.val == val){
                curr = curr.next;
                pre.next = curr;
            }else{ // only update pre if not matched
            pre = curr;
            curr = curr.next;
            }
        }
        return dummy.next;
    }
}