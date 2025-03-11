class Solution {
    public int[] applyOperations(int[] nums) {
        if(nums == null || nums.length < 2) return nums;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }
        int[] ret = new int[nums.length];
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0) ret[i++] = nums[j];
        }
        return ret;
    }
}