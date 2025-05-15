class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ret = 0;
        int len = nums.length;
        long sum = 0;
        for(int i = 0, j = 0; i < len; i++){
            sum += nums[i];
            while (j <= i && sum * (i - j + 1) >= k){
                sum -= nums[j];
                j++;
            }
            ret += i - j + 1;
        }
        return ret;
    }
}