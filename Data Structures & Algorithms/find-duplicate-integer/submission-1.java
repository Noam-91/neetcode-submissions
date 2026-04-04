class Solution {
    public int findDuplicate(int[] nums) {
        int[] checker = new int[nums.length+1];
        for(int num : nums){
            if(checker[num]==0){
                checker[num] = 1;
            }else{
                return num;
            }
        }
        return 0;
    }
}
