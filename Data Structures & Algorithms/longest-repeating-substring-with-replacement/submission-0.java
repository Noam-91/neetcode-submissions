class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int[] alph = new int[26];
        int max = 0;
        int len = 0;
        for(int r=0;r<s.length();r++){
            alph[s.charAt(r)-'A']++;
            max = Math.max(max, alph[s.charAt(r)-'A']);
            while((r-l+1)-max > k){
                alph[s.charAt(l)-'A']--;
                l++;
            }
            len = Math.max(len, r-l+1);
        }
        return len;
    }
}
