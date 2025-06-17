class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ret = new LinkedList<>();
        if(nums == null || nums.length == 0){
            ret.add(Arrays.asList(lower, upper));
            return ret;
        }

        if(nums[0] - lower > 0){
            ret.add(Arrays.asList(lower, nums[0] - 1));
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] > 1){
                ret.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
            }
        }

        if(upper - nums[nums.length - 1] > 0){
            ret.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
        }
        return ret;
    }
}