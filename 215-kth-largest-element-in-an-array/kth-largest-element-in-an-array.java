class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }        
        int[] fre = new int[max - min + 1];
        for(int i = 0; i < nums.length; i++){
            fre[nums[i] - min]++;
        }
        for(int i = fre.length - 1; i >= 0; i--){
            if(fre[i] >= k){
                return min + i;
            }
            k -= fre[i];
        }
        return -1;
    }
}