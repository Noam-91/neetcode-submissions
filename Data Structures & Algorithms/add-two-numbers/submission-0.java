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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> numList = new ArrayList<>();
        int carrier = 0;
        while(l1!=null&&l2!=null){
            int sum = l1.val + l2.val + carrier;
            numList.add(sum%10);
            carrier = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val + carrier;
            numList.add(sum%10);
            carrier = sum/10;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = l2.val + carrier;
            numList.add(sum%10);
            carrier = sum/10;
            l2 = l2.next;
        }
        if(carrier!=0){
            numList.add(carrier);
        }
        ListNode curr = null;
        for(int i= numList.size()-1;i>=0;i--){
            ListNode temp = new ListNode(numList.get(i));
            temp.next = curr;
            curr = temp;
        }
        return curr;
    }
}
