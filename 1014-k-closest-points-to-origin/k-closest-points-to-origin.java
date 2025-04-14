class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for(int i = 0; i < points.length; i++){
            heap.offer(points[i]);
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[][] ret = new int[heap.size()][2];
        int i = 0;
        while(!heap.isEmpty()){
            ret[i++] = heap.poll();
        }
        return ret;
    }
}