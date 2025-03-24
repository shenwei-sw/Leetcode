class Solution {
    public boolean checkPowersOfThree(int n) {
        return helper(0, n);
    }

    public boolean helper(int power, int n){
        if(n == 0) return true;

        int p = (int)Math.pow(3, power);
        if(p > n) return false;
        boolean add = helper(power + 1, n - p);
        boolean skip = helper(power + 1, n);
        return add || skip;
    }
}