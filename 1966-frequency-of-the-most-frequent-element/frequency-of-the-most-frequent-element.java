class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length; 
        int left = 0; 
        int ret = 0;
        long sum = 0;
        for(int right = 0; right < len; right++){
            long target = nums[right];
            sum += target;

            while((right - left + 1) * target - sum > k){
                sum -= nums[left];
                left++;
            }

            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}