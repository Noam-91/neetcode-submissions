class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        list.add(newInterval);
        for(int[] interval : intervals){
            int[] last = list.get(list.size()-1);
            if(interval[1]<last[0]){
                list.add(list.size()-1, interval);
            }else if(last[1]>=interval[0]){
                list.set(list.size()-1, new int[] {Math.min(last[0], interval[0]), Math.max(last[1], interval[1])});
            }else{
                list.add(interval);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = list.get(i);
        }
        return res;
    }

}
