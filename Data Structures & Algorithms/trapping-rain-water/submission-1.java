class Solution {
    public int trap(int[] height) {
        // int[] leftBound = new int[height.length];
        // int[] rightBound = new int[height.length];
        // leftBound[0] = height[0];
        // rightBound[height.length-1] = height[height.length-1];
        // for(int i=1;i<height.length;i++){
        //     leftBound[i] = Math.max(leftBound[i-1],height[i]);
        //     rightBound[height.length-1-i] = Math.max(rightBound[height.length-i],height[height.length-1-i]);
        // }
        
        // int area = 0;
        // for(int i=0;i<height.length;i++){
        //     area+=Math.min(leftBound[i],rightBound[i]) - height[i];
        // }
        // return area;

        // Two pointers
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax = height[left];
                }else{
                    area+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>rightMax){
                    rightMax = height[right];
                }else{
                    area+=rightMax-height[right];
                }
                right--;
            }
        }
        return area;
    }
}
