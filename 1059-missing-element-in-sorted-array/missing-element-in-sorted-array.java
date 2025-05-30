class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int missed = nums[mid] - nums[0] - mid;
            if(missed < k){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        //return right + k + nums[0];
        int missed = nums[right] - nums[0] - right;
        return nums[right] + k - missed;
    }
}