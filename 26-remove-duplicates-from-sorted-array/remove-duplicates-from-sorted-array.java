class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int cur = 1;
        while(cur < nums.length){
            if(nums[cur] != nums[start]){
                start++;
                nums[start] = nums[cur];
            }
            cur++;
        }
        return start + 1;
    }
}