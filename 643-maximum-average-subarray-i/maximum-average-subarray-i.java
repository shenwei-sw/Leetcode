class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int i;
        for(i = 0; i < k; i++){
            sum += nums[i];
        }
        int max = sum;
        while(i < nums.length){
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
            i++;
        }
        return max * 1.0 / k ;
    }
}