/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node p = head;
        Map<Node,Node> map = new HashMap<>();
        int i = 0;
        while(p!=null){
            Node temp = new Node(p.val);
            map.put(p,temp);
            p = p.next;
        }
        p = head;
        while(p!=null){
            Node curr = map.get(p);
            curr.next = map.get(p.next);
            curr.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

}
