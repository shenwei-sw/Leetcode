class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max_sum = nums[0];
        int max = nums[0];
        int min_sum = nums[0];
        int min = nums[0];
        int total = nums[0];
        for(int i = 1; i < nums.length; i++){
            max_sum = Math.max(nums[i], max_sum + nums[i]);
            max = Math.max(max, max_sum);

            min_sum = Math.min(nums[i], min_sum + nums[i]);
            min = Math.min(min, min_sum);

            total += nums[i];
        }

        if(min == total) return max;

        return Math.max(max, total - min);
    }
}