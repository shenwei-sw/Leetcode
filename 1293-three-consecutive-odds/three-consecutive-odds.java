class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] % 2 == 0){
                count = 0;
            }
            else {
                count++;
                if(count >= 3) return true;
            }
        }
        return false;
    }
}