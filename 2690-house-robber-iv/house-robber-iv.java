class Solution {
    public int minCapability(int[] nums, int k) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(i < min) min = i;
            if(i > max) max = i;
        }
        while(min < max){
            int mid = (min + max) / 2;
            int thefts = 0;
            for(int i = 0; i < len; i++){
                if(nums[i] <= mid){
                    thefts++;
                    i++;
                }
            }
            if(thefts >= k) max = mid;
            else min = mid + 1;
        }
        return min;
    }
}