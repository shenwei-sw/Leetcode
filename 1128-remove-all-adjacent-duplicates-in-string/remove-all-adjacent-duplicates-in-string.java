class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ch == stack.peek()){
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}