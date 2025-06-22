class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    ret = Math.max(ret, dfs(grid, i, j));
                }
            }
        }
        return ret;
    }

    public int dfs(int[][] grid, int i, int j){
        if(!isIsland(grid, i, j)) return 0;
        grid[i][j] = 0;
        return 1 + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + dfs(grid, i + 1, j) + dfs(grid, i - 1, j);
     }

    public boolean isIsland(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return false;
        return true;
    }
}