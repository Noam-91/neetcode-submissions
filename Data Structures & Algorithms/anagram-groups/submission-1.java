class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        if(strs.length==1){
            return List.of(List.of(strs[0]));
        }
        for(String str:strs){
            String key = hash(str);
            map.computeIfAbsent(key, k->new ArrayList<>()).add(str);
        }

        return new ArrayList(map.values());
    }
    private String hash(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
