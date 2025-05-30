class Solution {
    public String decodeString(String s) {
        int len = s.length();
        int index = 0;
        int digit = 0;
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(index < len){
            char ch = s.charAt(index);
            if(Character.isDigit(ch)){
                digit = digit * 10 + ch - '0';
            }
            else if(ch == '['){
                intStack.push(digit);
                strStack.push(sb);
                digit = 0;
                sb = new StringBuilder();
            }
            else if (ch == ']'){
                int preDigit = intStack.pop();
                StringBuilder pre = strStack.pop();
                while(preDigit-- > 0){
                    pre.append(sb);
                }
                sb = pre;
            }
            else {
                sb.append(ch);
            }
            index++;
        }
        return new String(sb);
    }
}