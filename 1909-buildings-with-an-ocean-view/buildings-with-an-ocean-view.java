class Solution {
    public int[] findBuildings(int[] heights) {
        if(heights == null || heights.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        int max = heights[heights.length - 1];
        stack.push(heights.length - 1);
        for(int i = heights.length - 2; i >= 0; i--){
            if(heights[i] > max){
                stack.add(i);
            }
            max = Math.max(max, heights[i]);
        }
        int[] ret = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            ret[i++] = stack.pop();
        }
        return ret;
    }
}