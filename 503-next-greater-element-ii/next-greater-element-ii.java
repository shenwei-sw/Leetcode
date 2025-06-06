class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = len - 1; i >= 0; i--){
            stack.push(nums[i]);
        }
        int[] ret = new int[len];
        for(int i = len - 1; i >= 0; i--){
            ret[i] = -1;
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) ret[i] = stack.peek();
            stack.push(nums[i]);
        }
        return ret;
    }
}