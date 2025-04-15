class Solution {
    public String customSortString(String order, String s) {
        int len = s.length();
        Character[] chars = new Character[len];
        for(int i = 0; i < len; i++){
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, (a, b)-> {
            return order.indexOf(a) - order.indexOf(b);
            });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}