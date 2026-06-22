class KthLargest {
    PriorityQueue<Integer> pq;
    int size;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        this.pq = new PriorityQueue<>(k); 
        for(int i : nums){
            add(i);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>size){
            pq.poll();
        }
        return pq.peek();
    }
}
