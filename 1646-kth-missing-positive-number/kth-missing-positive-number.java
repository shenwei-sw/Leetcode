class Solution {
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int start = 0;
        for(int i = 1; i <= 2000; i++){
            if(start < len && arr[start] == i){
                start++;
            }
            else{
                k--;
                if(k == 0) return i;
            }
        }
        return -1;
    }
}