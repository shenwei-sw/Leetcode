class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> rList = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }
            else if(ch == ')'){
                if(stack.isEmpty()){
                    rList.add(i);
                }
                else stack.pop();
            }
        }
        while(!stack.isEmpty()){
            rList.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            if(!rList.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}