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
    public void reorderList(ListNode head) {
        //stack
        Stack<ListNode> stack = new Stack<>();

        //put every node in first in last out order
        ListNode p = head;
        while (p != null){
            stack.push(p);
            p = p.next;
        }

        // start from head again to reassing nodes
        p = head;
        while(p != null){
            ListNode last = stack.pop();
            ListNode next = p.next;
            
            //universal break condition for even or odd size linked list
            if(last == next || last.next == next){
                last.next =null;
                break;
            }

            //old p0 connect to pn, pn to old p1 
            p.next = last;
            last.next = next;

            //now start with old p1
            p = next;
        }
        
    }
}