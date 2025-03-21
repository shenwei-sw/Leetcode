class Solution {
    public int myAtoi(String s) {
        int cur = 0;
        int ret = 0;
        int len = s.length();
        boolean isNegative = false;
        while(cur < len && s.charAt(cur) == ' '){
            cur++;
        }
        if(cur < len && (s.charAt(cur) == '+' || s.charAt(cur) == '-')){
            if(s.charAt(cur) == '-')
                isNegative = true;
            cur++;
        }
        while(cur < len && Character.isDigit(s.charAt(cur))){
            int digit = s.charAt(cur) - '0';
            if(ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && digit > (Integer.MAX_VALUE % 10))){
                return isNegative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ret = ret * 10 + digit;
            cur++;
        }
        return isNegative? -ret : ret;
    }
}