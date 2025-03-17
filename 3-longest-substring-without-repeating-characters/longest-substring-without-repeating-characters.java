class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
                max = Math.max(max, i - start + 1);
            }
            else{
                int index = map.get(ch);
                while(start <= index){
                    map.remove(s.charAt(start++));
                }
                map.put(ch, i);
            }
        }
        return max;
    }
}