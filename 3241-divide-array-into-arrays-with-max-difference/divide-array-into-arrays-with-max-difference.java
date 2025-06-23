class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ret = new int[n / 3][3];
        for(int i = 0; i < n; i += 3){
            if(nums[i + 2] - nums[i] > k) return new int[0][0];
            ret[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ret;
    }
}