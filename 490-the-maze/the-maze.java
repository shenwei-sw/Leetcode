class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, m, n, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int m, int n, int[] cur, int[] end, boolean[][] visited){
        if(visited[cur[0]][cur[1]]) return false;
        if(cur[0] == end[0] && cur[1] == end[1]) return true;
        visited[cur[0]][cur[1]]  = true;
        int[] dirX = new int[]{0, 0, 1, -1};
        int[] dirY = new int[]{1, -1, 0, 0};
        for(int i = 0; i < 4; i++){
            int r = cur[0];
            int c = cur[1];
            while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0){
                r += dirX[i];
                c += dirY[i];
            }

            if(dfs(maze, m, n, new int[]{r - dirX[i], c - dirY[i]}, end, visited)) return true;
        }
        return false;
    }
}