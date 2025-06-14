class Solution {
    public double myPow(double x, int n) {
        return dfs(x, (long) n);
    }

    public double dfs(double x, long n){
        if(n < 0){
            x = 1.0 / x;
            n = -n;
        }
        double ret = 1;
        while(n != 0){
            if(n % 2 == 1){
                ret = ret * x;
                n -= 1;
            }
            x = x * x;
            n = n / 2;
        }
        return ret;
    }
}