class Solution {
    public int maxLength(int[] ribbons, int k) {
        int len = 0; 
        int left = 0;
        int right = ribbons[0];
        for(int ribbon : ribbons){
            right = Math.max(right, ribbon);
        }

        while(left < right){
            int mid = (left + right + 1) / 2;
            if(isPossible(mid, ribbons, k)){
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean isPossible(int cl, int[] ribbons, int k){
        int total = 0; 
        for(int ribbon : ribbons){
            total += ribbon / cl;
            if(total >= k) return true;
        }
        return false;
    }
}