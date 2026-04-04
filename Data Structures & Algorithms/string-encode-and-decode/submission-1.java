class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append("_");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<str.length()){
            while(str.charAt(i)!='_'){
                sb.append(str.charAt(i));
                i++;
                continue;
            }
            int len = Integer.parseInt(sb.toString());
            i++; // skip delimitor
            sb = new StringBuilder();
            while(len>0){
                sb.append(str.charAt(i));
                len--;
                i++;
            }
            res.add(sb.toString());
            sb = new StringBuilder();
        }
        return res;
    }
}
