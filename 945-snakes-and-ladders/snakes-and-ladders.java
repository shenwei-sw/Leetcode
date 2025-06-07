class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int index = 1;
        Integer[] cols = new Integer[n];
        for(int i = 0; i < n; i++){
            cols[i] = i;
        }
        for(int i = n - 1; i >= 0; i--){
            for(int col : cols){
                cells[index++] = new Pair<>(i, col);
            }
            Collections.reverse(Arrays.asList(cols));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[1] = 0;
        queue.offer(1);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next = cur + 1; next <= Math.min(cur + 6, n * n); next++){
                int row = cells[next].getKey();
                int col = cells[next].getValue();
                int des = board[row][col] != -1 ? board[row][col] : next;

                if(dist[des] == -1){
                    dist[des] = dist[cur] + 1;
                    queue.offer(des);
                }
            }
        }
        return dist[n * n];
    }
}