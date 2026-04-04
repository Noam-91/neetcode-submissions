class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null&&t==null){
            return true;
        }
        if(s==null^t==null || s.length()!=t.length()){
            return false;
        }
        int[] allChar = new int[128];
        for(int i=0;i<s.length();i++){
            int indexS = s.charAt(i) & 0x7F;
            int indexT = t.charAt(i) & 0x7F;
            allChar[indexS]++;
            allChar[indexT]--;
        }
        for(int i : allChar){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
