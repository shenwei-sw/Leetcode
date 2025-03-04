class Solution {
    public boolean check(int[] nums) {
        if(nums == null || nums.length == 0) return true;

        int start = 0; 
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]) {
                start = i; 
                break;
            }
        }
        System.out.println("start is " + start);
        for(int i = 1; i < nums.length; i++){
            int pre = nums[(start + i - 1) % nums.length];
            int cur = nums[(start + i) % nums.length];
            System.out.println(pre + "->" + cur);
            if(pre > cur) return false;
        }
        return true;
    }
}