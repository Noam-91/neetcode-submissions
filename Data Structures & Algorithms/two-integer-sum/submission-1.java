class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                return i>j? new int[]{j,i}:new int[]{i,j};
            }
            map.put(target-nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
