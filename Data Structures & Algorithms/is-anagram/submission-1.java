class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[128];
        if(s.length()==0&&t.length()==0) return true;
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)&0x7F]++;
            map[t.charAt(i)&0x7F]--;
        }
        for(int count:map){
            if(count!=0) return false;
        }
        return true;
    }
}
