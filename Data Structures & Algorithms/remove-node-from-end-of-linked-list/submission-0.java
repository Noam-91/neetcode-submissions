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
        int len = 0;
        ListNode p = head;
        while(p!=null){
            p = p.next;
            len++;
        }
        assert len>=n;
        int prevIdx = len-n-1;
        if(prevIdx==-1) return head.next;
        p = head;
        for(int i=0;i<prevIdx;i++){
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}
