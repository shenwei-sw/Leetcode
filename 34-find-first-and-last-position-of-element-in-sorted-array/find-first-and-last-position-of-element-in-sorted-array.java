class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;

        int start = -1;
        int end = -1;

        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if(nums[left] != target) return new int[]{start, end};
        start = left;

        left = 0;
        right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2 + 1;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        end = right;

        return new int[]{start, end};
    }
}