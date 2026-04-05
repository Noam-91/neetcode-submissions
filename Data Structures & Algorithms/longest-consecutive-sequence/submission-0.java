class Solution {
    static class Node{
        int val;
        Node next;
        Node prev;
        int len;
        Node(int val){
            this.val = val;
        }
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer,Node> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                continue;
            }
            Node curr = new Node(num);
            if(map.containsKey(num-1)){
                curr.prev = map.get(num-1);
                map.get(num-1).next = curr;
            }
            if(map.containsKey(num+1)){
                curr.next = map.get(num+1);
                map.get(num+1).prev = curr;
            }
            map.put(num,curr);
        }
        int maxLen = 0;
        for(Node node : map.values()){
            if(node.prev==null){
                int currLen = 0;
                while(node!=null){
                    currLen++;
                    node = node.next;
                }
                maxLen = Math.max(maxLen,currLen);
            }
        }
        return maxLen;
    }
}
