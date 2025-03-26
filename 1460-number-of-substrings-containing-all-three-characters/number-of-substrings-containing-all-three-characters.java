class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int left = 0, right = 0;
        int[] freq = new int[3];
        int ret = 0;

        while(right < len){
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            while(hasAll(freq)){
                ret += len - right;
                char leftch = s.charAt(left);
                freq[leftch - 'a']--;
                left++;
            }
            right++;
        }
        return ret;
    }

    public boolean hasAll(int[] freq){
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}