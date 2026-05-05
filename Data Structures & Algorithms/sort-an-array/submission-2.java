class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    private void quickSort(int[] nums, int low, int high){
        if(low>=high) return;
        int randomIdx = low + (int) (Math.random() * (high-low+1));
        swap(nums,low,randomIdx);
        int pivot = nums[low];
        int i = low-1;
        int j = high+1;
        while(i<j){
            do {i++;} while(nums[i]<pivot);
            do {j--;} while(nums[j]>pivot);
            if(i<j){
                swap(nums,i,j);
            }
        }
        quickSort(nums,low,j);
        quickSort(nums,j+1,high);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}