class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 0}, {-1, 0}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        if(board[x][y] != 'M' && board[x][y] != 'E'){
            return board;
        }

        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }

        int mines = countMines(board, x, y);
        if(mines > 0){
            board[x][y] = (char)(mines + '0');
            return board; 
        }
        board[x][y] = 'B';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d : dirs){
                x = cur[0] + d[0];
                y = cur[1] + d[1];
                if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E'){
                    continue;
                }
                mines = countMines(board, x, y);
                if(mines > 0){
                    board[x][y] = (char)(mines + '0');
                    continue;
                }
                board[x][y] = 'B';
                queue.offer(new int[]{x, y});
            }
        }
        return board;
    }

    private int countMines(char[][] board, int x, int y){
        int count = 0;
        for(int[] d : dirs){
            int r = x + d[0];
            int c = y + d[1];
            if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'M'){
                count++;
            }
        }
        return count;
    }
}