class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] map = new boolean[256];
        if(s.length()<=1) return s.length();
        int l=0, r=0;
        int max = 0;
        while(r<s.length()){
            max = Math.max(max,r-l);
            if(map[s.charAt(r)&0x7F]){
                while(s.charAt(l)!=s.charAt(r)){
                    max = Math.max(max,r-l);
                    map[s.charAt(l)&0x7F]=false;
                    l++;
                }
                l++;
            }
            map[s.charAt(r)&0x7F] = true;
            r++;
        }
        
        return Math.max(max,r-l);
    }
}
