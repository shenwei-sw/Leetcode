class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if(n < 3) return n;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        while(right < n){
            char ch = s.charAt(right);
            map.put(ch, right);
            if(map.size() > 2){
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                left = index + 1;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}