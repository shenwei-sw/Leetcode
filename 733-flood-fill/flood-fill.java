class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        dfs(image, sr, sc, oldColor, color);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int oldColor, int newColor){
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) return;

        image[r][c] = newColor;
        int[] xbeta = new int[]{-1, 1, 0, 0};
        int[] ybeta = new int[]{0, 0, -1, 1};
        for(int i = 0; i < 4; i++){
            dfs(image, r + xbeta[i], c + ybeta[i], oldColor, newColor);
        }
    }
}