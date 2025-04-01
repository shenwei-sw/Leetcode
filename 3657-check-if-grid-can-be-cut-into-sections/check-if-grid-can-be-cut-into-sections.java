class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }

    public boolean checkCuts(int[][] rectangles, int dim){
        int cuts = 0;
        Arrays.sort(rectangles, (a, b) -> (a[dim] - b[dim]));
        int endx = rectangles[0][dim + 2];
        for(int i = 1; i < rectangles.length; i++){
            if(rectangles[i][dim] >= endx) cuts++;
            endx = Math.max(endx, rectangles[i][dim + 2]);
        }
        return cuts >= 2;
    }
}