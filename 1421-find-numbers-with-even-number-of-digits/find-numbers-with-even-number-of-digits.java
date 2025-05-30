class Solution {
    public int findNumbers(int[] nums) {
        int ret = 0;
        for(int num : nums){
            if(calDigits(num) % 2 == 0) ret++;
        }
        return ret;
    }

    public int calDigits(int num){
        int digits = 0;
        while(num > 0){
            digits++;
            num /= 10;
        }
        return digits;
    }
}