class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null || s2==null || s2.length()<s1.length()) return false;
        int[] dict = new int[256];
        for(char c:s1.toCharArray()){
            dict[c&0x7F]++;
        }
        for(int i=0; i<s1.length(); i++){
            dict[s2.charAt(i)&0x7F]--;
        }
        if(isPm(dict)){
            return true;
        }
        for(int i=s1.length(); i<s2.length(); i++){
            char head = s2.charAt(i);
            char tail = s2.charAt(i-s1.length());
            dict[head&0x7F]--;
            dict[tail&0x7F]++;
            if(dict[head&0x7F]==0 && isPm(dict)){
                return true;
            }
        }
        return false;
    }
    private boolean isPm(int[] dict){
        for(int i:dict){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
