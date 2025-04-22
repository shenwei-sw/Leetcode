class Solution {
    int ret = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(0, 0, nums, target);
        return ret;
    }

    public void dfs(int index, int sum, int[] nums, int target){
        if(index == nums.length){
            if(sum == target) ret++;
            return;
        }
        dfs(index + 1, sum + nums[index], nums, target);
        dfs(index + 1, sum - nums[index], nums, target);
    }
}