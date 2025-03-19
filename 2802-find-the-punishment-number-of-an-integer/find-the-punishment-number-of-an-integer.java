class Solution {
    public int punishmentNumber(int n) {
        int ret = 0; 
        for(int i = 1; i <= n; i++){
            if(check(i * i, i)) ret += i * i;
        }
        return ret;
    }

    public boolean check(int sqt, int i){
        if(i < 0 || i > sqt){
            return false;
        }

        if(sqt == i){
            return true;
        }

        return check(sqt / 10, i - sqt % 10) || check(sqt / 100, i - sqt % 100) || check(sqt / 1000, i - sqt % 1000);
    }
}