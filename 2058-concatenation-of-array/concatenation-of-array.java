class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len * 2];
        for(int i = 0; i < ans.length; i++){
            if(i < len) ans[i] = nums[i];
            else ans[i] = nums[i - len];
        }
        return ans;
    }
}