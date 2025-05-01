class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ret = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X'){
                    dfs(i, j, board);
                    ret++;
                }
            }
        }
        return ret;
    }

    public void dfs(int i, int j, char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.'){
            return;
        }
        board[i][j] = '.';
        int[] lenx = new int[]{1, -1, 0, 0};
        int[] leny = new int[]{0, 0, 1, -1};
        for(int k = 0; k < lenx.length; k++){
            dfs(i + lenx[k], j + leny[k], board);
        }
    }
}