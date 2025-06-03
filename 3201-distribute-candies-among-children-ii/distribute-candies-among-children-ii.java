class Solution {
    public long distributeCandies(int n, int limit) {
        long ret = 0;
        for(int i = 0; i <= Math.min(limit, n); i++){
            if(n - i > 2 * limit) continue;
            ret += Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1;
        }
        return ret;
    }
}