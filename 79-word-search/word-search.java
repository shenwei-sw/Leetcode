class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, visited, word, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int index){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        
        visited[i][j] = true;
        boolean ret = dfs(board, i + 1, j, visited, word, index + 1) ||
        dfs(board, i - 1, j, visited, word, index + 1) ||
        dfs(board, i, j + 1, visited, word, index + 1) ||
        dfs(board, i, j - 1, visited, word, index + 1);
        visited[i][j] = false;
        return ret;
    }
}