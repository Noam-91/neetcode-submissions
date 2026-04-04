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
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr!=null && next!=null){
            try{
                curr = curr.next;
                next = next.next.next;
                if(curr==next){
                    return true;
                }
            }catch(Exception e){
                return false;
            }
            
        }
        return false;
    }
}
