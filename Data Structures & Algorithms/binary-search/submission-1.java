class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0||nums[nums.length-1]<target) return -1;
        int l = 0, r = nums.length;
        while(l<r){
            int m = l+(r-l)/2;
            if(nums[m]<target){
                l = m+1;
            }else{
                r = m;
            }
        }
        return nums[l]==target? l : -1;
    }
}
