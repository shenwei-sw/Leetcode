class Solution {
    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        int left = 0;
        int right = 0;
        for(int i = 0; i < nums.length; i++){
            left = sum[i] - nums[i];
            right = i != nums.length - 1? sum[nums.length - 1] - sum[i] : 0;
            if(left == right) return i;
        }
        return -1;
    }
}