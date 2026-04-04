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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
        Arrays.stream(lists).forEach(list->{
            while(list!=null){
                pq.offer(list);
                list = list.next;
            }
        });
        ListNode head = pq.poll();
        ListNode prev = head;
        ListNode curr = null;
        while(!pq.isEmpty()){
            curr = pq.poll();
            prev.next = curr;
            prev = curr;
        }
        curr.next = null;
        return head;
    }
}
