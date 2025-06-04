class Solution {
    public int maxPower(String s) {
        int left = 0;
        int right = 1;
        int len = s.length();
        int ret = 0;
        while(right < len){
            while(right < len && s.charAt(right) == s.charAt(left)){
                right++;
            }
            ret = Math.max(ret, right - left);
            left = right;
        }
        ret = Math.max(ret, right - left);
        return ret;
    }
}