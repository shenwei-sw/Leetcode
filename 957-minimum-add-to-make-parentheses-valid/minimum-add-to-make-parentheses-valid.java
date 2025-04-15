class Solution {
    public int minAddToMakeValid(String s) {
        int ret = 0;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else {
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else 
                    ret++;
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            ret++;
        }
        return ret;
    }
}