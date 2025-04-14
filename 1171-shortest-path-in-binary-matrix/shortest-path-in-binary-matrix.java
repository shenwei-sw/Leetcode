class Solution {
    private static final int[][] directions = 
        new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int val = grid[row][col];
            if(row == grid.length - 1 && col == grid.length - 1) return val;
            for(int i = 0; i < directions.length; i++){
                if(!isValid(grid, row + directions[i][0], col + directions[i][1])) continue;
                grid[row + directions[i][0]][col + directions[i][1]] = val + 1;
                queue.offer(new int[]{row + directions[i][0], col + directions[i][1]});
            }
        }
        return -1;
    }

    public boolean isValid(int[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 0)
            return false; 
        else 
            return true;
    }
}