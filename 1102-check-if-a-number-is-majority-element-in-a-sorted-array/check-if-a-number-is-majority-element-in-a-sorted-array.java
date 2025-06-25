class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] >= target){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return right + len / 2 < len && nums[right + len / 2] == target;
    }
}