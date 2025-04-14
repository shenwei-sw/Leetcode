class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
        for(Integer key : map.keySet()){
            heap.offer(key);
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[] ret = new int[k];
        for(int i = 0; i < k; i++){
            ret[i] = heap.poll();
        }
        return ret;
    }
}