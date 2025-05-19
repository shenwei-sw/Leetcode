class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        List<Integer> lis = new LinkedList<>();
        lis.add(nums[0]);
        for(int i = 1; i < len; i++){
            if(nums[i] > lis.get(lis.size() - 1)){
                lis.add(nums[i]);
            }
            else{
                int pos = Collections.binarySearch(lis, nums[i]);
                if(pos < 0) pos = - pos - 1;
                lis.set(pos, nums[i]);
            }
        }
        return lis.size();
    }
}