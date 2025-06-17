class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int cur = 0;
        int ms = 0;
        int ml = 0;
        while(cur < len){
            int i = cur;
            int j = cur;
            int ch = s.charAt(cur);
            while(i >= 0 && s.charAt(i) == ch) i--;
            while(j < len && s.charAt(j) == ch) j++;
            cur = j;
            while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            if(j - 1 -i > ml){
                ms = i + 1;
                ml = j - i - 1;
            }
        }
        return s.substring(ms, ms + ml);
    }
}