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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // we have to use a dummy node, because the node class dont have a previous pointer
        // so we have to find the previous node and link it to next.next to delete the node
        // we need this dummy incase of return nth node from end which is head
        // node before head is null which dont have next
        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;
        dp.next = head;
        //now we find the node before the delete node
        ListNode prevDelNode = findNthFromEnd(dp, n+1);
        prevDelNode.next = prevDelNode.next.next;
        //now return dummy.next
        return dummy.next;
    }
    
    public ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        
        //p1 firstly move by n
        for(int i=0; i <n; i++){
            p1 = p1.next;
        }
        // now p2 move until p1 finishes which means p2 move total length - n steps
        // p2 is now n nodes away from the end        
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}