class MyHashSet {
    private List<Integer>[] buckets;
    private int size=0;
    private int capacity=0;

    public MyHashSet() {
        buckets = new LinkedList[10];
        capacity=10;
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public void add(int key) {
        if(size==capacity){
            this.capacity = this.capacity*2;
            List<Integer>[] newBuckets = new LinkedList[this.capacity];
            
            for (int i = 0; i < newBuckets.length; i++) {
                newBuckets[i] = new LinkedList<>();
            }
            for(int i=0;i<buckets.length;i++){
                for(int num : buckets[i]){
                    newBuckets[hashing(num)].add(num);
                }
            }
            buckets= newBuckets;
            
        }

        if(!contains(key)){
            buckets[hashing(key)].add(key);
            size++;
        }
    }
    
    public void remove(int key) {
        List<Integer> bucket = buckets[hashing(key)];
        if (bucket.remove((Integer) key)) {
            size--;
        }
    }
    
    public boolean contains(int key) {
        List<Integer> bucket = buckets[hashing(key)];
        return bucket!=null && bucket.contains(key);
    }
    private int hashing(int key){
        return Math.abs(key)%capacity;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */