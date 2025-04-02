class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] endIndex = new int[26];
        int len = s.length();
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            endIndex[ch - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        List<Integer> ret = new LinkedList<>();
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            end = Math.max(end, endIndex[ch - 'a']);
            if(end == i){
                ret.add(end - start + 1);
                start = end + 1;               
            }
        }
        return ret;
    }
}