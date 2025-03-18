class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0; 
        int sums[] = new int[nums.length + 1];
        sums[0] = 0;
        for(int i = 1; i < sums.length; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        } 
        for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < sums.length; j++){
                if(sums[j] - sums[i] == k) count++;
            }
        return count;
    }
}