class Solution {
    public int maximumDifference(int[] nums) {
        int ret = -1;
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            else if(nums[i] > min) {
                ret = Math.max(ret, nums[i] - min);
            }
        }
        return ret;
    }
}