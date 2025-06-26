class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        int max = leftMax[0];
        for(int i = 1; i < len; i++){
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        rightMax[len - 1] = height[len - 1];
        max = rightMax[len - 1];
        for(int i = len - 2; i >= 0; i--){
            max = Math.max(max, height[i]);
            rightMax[i] = max;   
        }
        int ret = 0;
        for(int i = 0; i < len; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(water >0) ret += water;
        }
        return ret;
    }
}