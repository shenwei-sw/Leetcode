class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int len = trips.length;
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        for(int[] trip : trips){
            while(!heap.isEmpty() && heap.peek()[2] <= trip[1]){
                capacity += heap.poll()[0];
            }
            capacity -= trip[0];
            heap.offer(trip);
            if(capacity < 0) return false;
        }
        return true;
    }
}