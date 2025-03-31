class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int pre = 0;
        int cur = nums[0];
        int next;
        for(int i = 2; i <= len; i++){
            next = Math.max(pre + nums[i - 1], cur);
            pre = cur;
            cur = next;
        }
        return cur;
    }
}