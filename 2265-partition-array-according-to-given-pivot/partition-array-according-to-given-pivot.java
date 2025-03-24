class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ret = new int[nums.length];
        int less = 0;
        int more = nums.length - 1;
        for(int i = 0, j = nums.length - 1; i < nums.length; i++, j--){
            if(nums[i] < pivot){
                ret[less++] = nums[i];
            }
            if(nums[j] > pivot){
                ret[more--] = nums[j];
            }
        }
        while(less <= more){
            ret[less++] = pivot;
        }
        return ret;
    }
}