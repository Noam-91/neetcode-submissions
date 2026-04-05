class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while(left<right){
            maxArea = Math.max(maxArea,getArea(heights,left,right));
            if(heights[left]>heights[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
    private int getArea(int[] heights,int left, int right){
        return Math.min(heights[left],heights[right])*(right-left);
    }
}
