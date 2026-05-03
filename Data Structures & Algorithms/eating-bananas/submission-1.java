class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max= Arrays.stream(piles).max().getAsInt();
        while(min<max){
            int mid = min + (max-min)/2;
            double time = 0;
            for(int pile:piles){
                time += (pile + mid - 1) / mid;
            }
            if(time>h){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }
}
