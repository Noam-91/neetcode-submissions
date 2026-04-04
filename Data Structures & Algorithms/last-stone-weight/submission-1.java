class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.offer(Math.abs(s1-s2));
        }
        return pq.isEmpty()? 0 : pq.poll();
    }
}
