class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]+nums[i]==0){
                    if(res.isEmpty() ||
                    !(res.get(res.size()-1).get(0)==nums[i] &&
                    res.get(res.size()-1).get(1)==nums[left] &&
                    res.get(res.size()-1).get(2)==nums[right])){
                        res.add(List.of(nums[i],nums[left],nums[right]));
                    }
                    left++;
                }else if(nums[left]+nums[right]+nums[i]<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
