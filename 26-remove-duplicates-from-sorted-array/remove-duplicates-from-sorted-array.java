class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int value = nums[start];
        int cur = 1;
        while(cur < nums.length){
            if(nums[cur] != value){
                value = nums[cur];
                start++;
                nums[start] = value;
            }
            cur++;
        }
        return start + 1;
    }
}