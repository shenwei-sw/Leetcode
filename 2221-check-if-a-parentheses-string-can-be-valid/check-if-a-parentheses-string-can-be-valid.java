class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> bs = new Stack<>();
        Stack<Integer> lb = new Stack<>();
        int len = s.length();
        if(len % 2 == 1) return false;

        for(int i = 0; i < len; i++){
            char sc = s.charAt(i);
            char lc = locked.charAt(i);
            if(lc == '0'){
                lb.push(i);
            }
            else if (sc == '('){
                bs.push(i);
            }
            else {
                if(!bs.isEmpty()){
                    bs.pop();
                }
                else if(!lb.isEmpty()){
                    lb.pop();
                }
                else return false;
            }
        }
        while(!bs.isEmpty() && !lb.isEmpty() && bs.peek() < lb.peek()){
            bs.pop();
            lb.pop();
        }
        return bs.isEmpty();
    }
}