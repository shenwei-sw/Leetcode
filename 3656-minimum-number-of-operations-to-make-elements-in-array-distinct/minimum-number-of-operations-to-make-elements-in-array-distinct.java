class Solution {
    public int minimumOperations(int[] nums) {
        if(nums.length == 0) return 0;

        int len = nums.length; 
        Set<Integer> set = new HashSet<>();
        for(int i = len - 1; i >= 0; i--){
            if(set.contains(nums[i]))
                return i / 3 + 1;
            set.add(nums[i]);
        }
        return 0;
    }
}