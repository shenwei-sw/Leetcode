class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int timestamp = 2;
        while(bfs(grid, m, n, timestamp)){
            timestamp++;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return timestamp - 2; 
    }

    private boolean bfs(int[][] grid, int m, int n, int timestamp){
        boolean toBeContinue = false;
        int[] dirX = new int[]{0, 0, 1, -1};
        int[] dirY = new int[]{1, -1, 0, 0};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == timestamp){
                    for(int k = 0; k < 4; k++){
                        int ix = i + dirX[k];
                        int jy = j + dirY[k];
                        if(ix >= 0 && ix < m && jy >= 0 && jy < n && grid[ix][jy] == 1){
                            grid[ix][jy] = timestamp + 1;
                            toBeContinue = true; 
                        }
                    }
                }
            }
        }
        return toBeContinue;
    }
}