class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int i = nums.length - 2;
        while(i >= 0){
            if(nums[i] < nums[i + 1]){
                int j = nums.length - 1;
                while(nums[i] >= nums[j]){
                    j--;
                }
                swap(nums, i, j);
                break;
            }
            i--;
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int p, int q){
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public void reverse(int[] nums, int left){
        int right = nums.length - 1;
        while(left <= right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}