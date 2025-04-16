class Solution {
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 2;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    map.put(index, dfs(grid, index, i, j));
                    index++;
                }
            }

        if(map.size() == 0) return 1;
        if(map.size() == 1){
            return grid.length * grid[0].length == map.get(2)? map.get(2) : map.get(2) + 1;
        }
        int max = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    int cur = 1;
                    Set<Integer> set = new HashSet<>();
                    if(j - 1 >= 0 && isIsland(grid, i, j - 1) && !set.contains(grid[i][j - 1])){
                        set.add(grid[i][j - 1]);
                        cur += map.get(grid[i][j - 1]);
                    }
                    if(j + 1 < grid[0].length && isIsland(grid, i, j + 1) && !set.contains(grid[i][j + 1])){
                        set.add(grid[i][j + 1]);
                        cur += map.get(grid[i][j + 1]);
                    }
                    if(i - 1 >= 0 && isIsland(grid, i - 1, j) && !set.contains(grid[i - 1][j])){
                        set.add(grid[i - 1][j]);
                        cur += map.get(grid[i - 1][j]);
                    }
                    if(i + 1 >= 0 && isIsland(grid, i + 1, j) && !set.contains(grid[i + 1][j])){
                        set.add(grid[i + 1][j]);
                        cur += map.get(grid[i + 1][j]);
                    }
                    max = Math.max(max, cur);
                }
            }
        return max;
    }

    public int dfs(int[][] grid, int index, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return 0;
        grid[x][y] = index;
        return 1 + dfs(grid, index, x + 1, y) + dfs(grid, index, x - 1, y) + dfs(grid, index, x, y + 1) + dfs(grid, index, x, y - 1);
    }

    public boolean isIsland(int[][] grid, int x, int y){
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] >= 1) return true;
        else return false;
    }
}