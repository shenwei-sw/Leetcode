class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int left = 0; 
        int right = len - 1;
        int[] ret = new int[len];
        for(int i = len - 1; i >= 0; i--){
            int sqrt = 0;
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                sqrt = nums[left];
                left++;
            }
            else {
                sqrt = nums[right];
                right--;
            }
            ret[i] = sqrt * sqrt;
        }
        return ret;
    }
}