class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        List<Integer> sortedKeys = freqMap.entrySet().stream()
        .sorted((e1,e2)->e2.getValue()-e1.getValue())
        .map(e->e.getKey())
        .toList();
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = sortedKeys.get(i);
        }
        return res;
    }
}
