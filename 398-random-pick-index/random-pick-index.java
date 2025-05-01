class Solution {
    private Map<Integer, List<Integer>> map;
    private Random rand;

    public Solution(int[] nums) {
        rand = new Random();
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new LinkedList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int len = map.get(target).size();
        return map.get(target).get(rand.nextInt(len));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */