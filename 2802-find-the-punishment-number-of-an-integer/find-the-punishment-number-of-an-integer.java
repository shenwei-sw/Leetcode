class Solution {
    public int punishmentNumber(int n) {
        int ret = 0; 
        for(int i = 1; i <= n; i++){
            if(check(Integer.toString(i * i), i)) ret += i * i;
        }
        return ret;
    }

    public boolean check(String sqt, int i){
        if(i < 0){
            return false;
        }

        if(sqt.isEmpty() && i == 0){
            return true;
        }

        for(int k = 0; k < sqt.length(); k++){
            String left = sqt.substring(0, k + 1);
            String right = sqt.substring(k + 1);

            int leftNum = Integer.parseInt(left);
            if(check(right, i - leftNum)) return true;
        }
        return false;
    }
}