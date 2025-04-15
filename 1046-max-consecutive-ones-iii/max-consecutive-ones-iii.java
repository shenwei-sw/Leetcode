class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int ret = 0;
        int nz = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                nz++;
            }
            while(nz > k){
                if(nums[left] == 0){
                    nz--;
                }
                left++;
            }

            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}