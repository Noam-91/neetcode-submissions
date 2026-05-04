class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(true){
            if(strs[0].length()==i){
                return sb.toString();
            }
            char c = strs[0].charAt(i);
            for(String str:strs){
                if(str.length()==i || str.charAt(i)!=c){
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
    }
}