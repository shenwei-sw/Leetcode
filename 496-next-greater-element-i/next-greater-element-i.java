class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()) map.put(stack.pop(), -1);
        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }
}