class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int val = arr[mid] - (mid + 1);
            if(val < k){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

        }
        return low + k;
    }
}