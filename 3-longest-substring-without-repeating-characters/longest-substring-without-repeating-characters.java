class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch));
            }
            max = Math.max(max, i - start + 1);
            map.put(ch, i + 1);
        }
        return max;
    }
}