class Solution {
    int index = 0;
    public String decodeString(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        while(index < len && s.charAt(index) != ']'){
            if(!Character.isDigit(s.charAt(index))){
                sb.append(s.charAt(index));
                index++;
            }
            else {
                int digit = 0;
                while(index < len && Character.isDigit(s.charAt(index))){
                    digit = digit * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++;
                String str = decodeString(s);
                index++;
                while(digit-- > 0){
                    sb.append(str);
                }
            }
        }
        return new String(sb);
    }
}