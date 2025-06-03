class Solution {
    public int distributeCandies(int n, int limit) {
        return calculateCobination(n + 2) - calculateCobination(n + 2 - (limit + 1)) * 3 + calculateCobination(n + 2 - 2 * (limit + 1)) * 3 
        - calculateCobination(n + 2 - 3 * (limit + 1));
    }

    private int calculateCobination(int x){
        if(x < 0) return 0;
        return x * (x - 1) / 2;
    }
}