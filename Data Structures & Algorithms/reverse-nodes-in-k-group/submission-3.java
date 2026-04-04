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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2) return head;
        List<ListNode> list = split(head,k);
        list = list.stream().map(node->reverseK(node,k)).collect(Collectors.toList());
        ListNode tail = null;
        head = list.get(0);
        for(ListNode p : list){
            if(tail!=null){
                tail.next = p;
            }
            while(p!=null && p.next!=null){
                p = p.next;
            }
            tail = p;
        }
        return head;
    }
    public List<ListNode> split(ListNode head, int k){
        List<ListNode> list = new ArrayList<>();
        ListNode prev = null;
        ListNode curr = head;
        list.add(head);
        int i = k;
        while(head!=null){
            if(i>0){
                prev = head;
                head = head.next;
                i--;
            }else{
                prev.next = null;
                list.add(head);
                i = k;
            }
        }
        return list;
    }

    public ListNode reverseK(ListNode head, int k){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }        
        if(k>0) return reverse(prev);
        return prev;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
