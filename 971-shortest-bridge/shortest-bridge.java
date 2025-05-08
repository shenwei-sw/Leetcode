class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int dis = 0;
        int firstx = -1;
        int firsty = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    firstx = i;
                    firsty = j;
                    break;
                }
            }
        }
        dfs(grid, firstx, firsty, queue);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                int[] dx = new int[] {0, 0, -1, 1};
                int[] dy = new int[] {-1, 1, 0, 0};
                for(int j = 0; j < dx.length; j++){
                    int curx = x + dx[j];
                    int cury = y + dy[j];
                    if(curx >= 0 && curx < n && cury >= 0 && cury < n ){
                        if(grid[curx][cury] == 1){
                            return dis;
                        }
                        else if(grid[curx][cury] == 0){
                            grid[curx][cury] = -1;
                            queue.offer(new int[]{curx, cury});
                        }
                    }
                }
            }
            dis++;
        }
        return dis;
    }

    public void dfs(int[][] grid, int x, int y, Queue<int[]> queue){
        grid[x][y] = 2;
        queue.offer(new int[]{x, y});
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        for(int i = 0; i < dx.length; i++){
            int curx = x + dx[i];
            int cury = y + dy[i];
            if(curx >= 0 && curx < grid.length && cury >= 0 && cury < grid.length && grid[curx][cury] == 1){
                dfs(grid, curx, cury, queue);
            }
        }
    }
}