class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        return count;
    }

    public void dfs(int i, int j, char[][] grid){
        grid[i][j] = '0';
        int[] row = new int[]{1, -1, 0, 0};
        int[] col = new int[]{0, 0, 1, -1};
        for(int k = 0; k < row.length; k++)
            if(isIsland(i + row[k], j + col[k], grid)) dfs(i + row[k], j + col[k], grid);
    }

    public boolean isIsland(int i, int j, char[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') return true;
        else return false;
    }
}