class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = (right + left) / 2;
            boolean isEven = (right - mid) % 2 == 0;
            if(nums[mid + 1] == nums[mid]){
                if(isEven){               
                    left = mid + 2;
                }
                else {
                    right = mid - 1;
                }
            }
            else if (nums[mid - 1] == nums[mid]){
                if(isEven){
                    right = mid - 2;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}