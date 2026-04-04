class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<= nums.length;i++){
            if(map.containsKey(nums[i])){
                int num2Idx = map.get(nums[i]);
                return i<num2Idx? new int[]{i,num2Idx} : new int[]{num2Idx,i};
            }
            map.put(target-nums[i], i);
        }
        return null;
    }
}
