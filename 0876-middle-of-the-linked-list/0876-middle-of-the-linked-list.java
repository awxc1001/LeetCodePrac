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
    public ListNode middleNode(ListNode head) {
        // use fast pointer to move by 2, slow pointer to move by 1
        // by the time fast finish, slow will reach the middle
        ListNode fastP = head;
        ListNode slowP = head;
        
        // incase we have next is null, we cannnot have null.next
        while(fastP != null && fastP.next != null){
            fastP = fastP.next.next;
            slowP = slowP.next;
        }
        return slowP;
    }
}