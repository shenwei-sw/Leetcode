class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int left = 1; 
        int right = 1;
        for(int i = 0; i < len; i++){
            right = Math.max(right, piles[i]);
        }
        while(left < right){
            int mid = (left + right) / 2;
            int curh = 0;
            for(int i = 0; i < len; i++){
                curh += Math.ceil((double)piles[i] / mid);
            }
            if(curh <= h){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }
}