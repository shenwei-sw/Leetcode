class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<HeapNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        int n = matrix.length;
        for(int i = 0; i < Math.min(n, k); i++){
            heap.offer(new HeapNode(matrix[i][0], i, 0));
        }

        HeapNode top = heap.peek();
        while(k > 0){
            top = heap.poll();
            int r = top.getRow();
            int c = top.getCol();
            if(c < n - 1){
                heap.offer(new HeapNode(matrix[r][c + 1], r, c + 1));
            }
            k--;
        }
        return top.getVal();
    }

    class HeapNode{
        public int val;
        public int row;
        public int col;

        public HeapNode(int _val, int _row, int _col){
            val = _val;
            row = _row;
            col = _col;
        }

        public int getVal(){
            return val;
        }

        public int getRow(){
            return row;
        }

        public int getCol(){
            return col;
        }
    }
}