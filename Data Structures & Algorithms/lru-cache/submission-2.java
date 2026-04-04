class LRUCache {
    Map<Integer, Integer> cache;
    Deque<Integer> dq;
    int capacity; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.dq = new ArrayDeque<>(capacity);
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            dq.remove(key);
            dq.offer(key);
        }

        return cache.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if(cache.size()==this.capacity && !cache.containsKey(key)){
            int deletedKey = dq.poll();
            cache.remove(deletedKey);
        }
        if(cache.containsKey(key)){
            dq.remove(key); 
        }
        dq.offer(key);
        cache.put(key,value);
    }
}
