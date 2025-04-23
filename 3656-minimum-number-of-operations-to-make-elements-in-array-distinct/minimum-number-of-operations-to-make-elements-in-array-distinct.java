class Solution {
    public int minimumOperations(int[] nums) {
        if(nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if(map.size() == nums.length) return 0;
        int ret = 0;
        int i = 0;
        for(; i < nums.length; i++){
            map.put(nums[i], map.get(nums[i]) - 1);
            if(map.get(nums[i]) == 0) map.remove(nums[i]);
            if(i % 3 == 2){
                ret++;
                if(map.size() == nums.length - i - 1) return ret;
            }
        }
        if(i % 3 != 0) ret++;
        return ret;
    }
}