class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        char op = '+';
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                cur = cur * 10 + ch - '0';
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == len - 1){
                if(op == '+'){
                    stack.push(cur);
                }
                else if(op == '-'){
                    stack.push(-cur);
                }
                else if(op == '*'){
                    stack.push(stack.pop() * cur);
                }
                else {
                    stack.push(stack.pop() / cur);
                }
                cur = 0;
                op = ch;
           }

        }
        int ret = 0; 
        while(!stack.isEmpty()){
            ret += stack.pop();
        }
        return ret;
    }
}