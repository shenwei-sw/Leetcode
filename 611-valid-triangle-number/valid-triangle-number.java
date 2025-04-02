class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length; 
        for(int i = 0; i < len - 2; i++){
            int k = i + 2;
            for(int j = i + 1; j < len - 1 && nums[i] > 0; j++){
                while(k < nums.length && nums[i] + nums[j] > nums[k]){
                    k++;
                }
                count += k - 1 - j + 1  - 1;
            }
        }
        return count;
    }
}