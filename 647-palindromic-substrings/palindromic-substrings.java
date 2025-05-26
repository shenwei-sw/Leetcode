class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int ret = 0;

        for(int i = 0; i < len; i++){
            ret += dfs(s, i, i);
            ret += dfs(s, i, i + 1);
        }
        return ret;
    }

    public int dfs(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}