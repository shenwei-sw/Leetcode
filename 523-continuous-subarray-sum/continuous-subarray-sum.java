class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(prefixMod, -1);
        for(int i = 0; i < nums.length; i++){
            prefixMod = (prefixMod + nums[i]) % k;
            if(map.containsKey(prefixMod)){
                if(i - map.get(prefixMod) > 1) return true;
            }
            else {
                map.put(prefixMod, i);
            }
        }
        return false;
    }
}