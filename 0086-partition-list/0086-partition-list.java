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
    public ListNode partition(ListNode head, int x) {
        
        //create two linked list to merge them, so two dummy heads
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        
        //pointers
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        
        while(p != null){
            
            if(p.val < x){
                //assign p not p.next
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }
    //after assign break down the orignal link, so oringal linked list is removed
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        
        //merge, dont froget ignore all the dummies
        p1.next = dummy2.next;
        return dummy1.next;
    }
}