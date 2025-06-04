class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int len = nums.length;
        int operations = 0; 
        int[] delta = new int[len + 1];

        for(int i = 0, j = 0; i < nums.length; i++){
            operations += delta[i];
            while(j < queries.length && queries[j][0] == i){
                heap.offer(queries[j][1]);
                j++;
            }

            while(operations < nums[i] && !heap.isEmpty() && heap.peek() >= i){
                operations++;
                delta[heap.poll() + 1]--;
            }

            if(operations < nums[i]){
                return -1;
            }
        }
        return heap.size(); 
    }
}