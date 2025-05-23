class Solution {
    public boolean validPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1;
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l== r){
                left++;
                right--;
            }
            else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l != r) return false;
            left++;
            right--;
        }
        return true;
    }
}