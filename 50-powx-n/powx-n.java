class Solution {
    public double myPow(double x, int n) {
        return dfs(x, (long) n);
    }

    public double dfs(double x, long n){
        if(n == 0) return 1;
        if(n < 0) return 1 / dfs(x, -n);
        if(n % 2 == 1) return x * dfs(x * x, (n - 1) / 2);
        return dfs(x * x, n / 2);
    }
}