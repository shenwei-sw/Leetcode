class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int c1 = 0;
        int c2 = 0;
        int l1 = word1 == null ? 0 : word1.length();
        int l2 = word2 == null ? 0 : word2.length();
        int i = 0;
        while(c1 < l1 && c2 < l2){
            if(i % 2 == 0){
                sb.append(word1.charAt(c1++));
            }
            else {
                sb.append(word2.charAt(c2++));
            }
            i++;
        }
        while(c1 < l1){
            sb.append(word1.charAt(c1++));
        }
        while(c2 < l2){
            sb.append(word2.charAt(c2++));
        }
        return sb.toString();
    }
}