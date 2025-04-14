class Solution {
    int[] sums; 
    int sum = 0;
    public Solution(int[] w) {
        sums = new int[w.length];
        for(int i = 0; i < sums.length; i++){
            sum += w[i];
            sums[i] = sum;
        }
    }
    
    public int pickIndex() {
        double target = sum * Math.random();
        int low = 0;
        int high = sums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(target > sums[mid]){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return high;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */