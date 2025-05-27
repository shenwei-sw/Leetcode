class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 0;
        int pre = Integer.parseInt(s[2]);
        while(i < logs.size()){
            s = logs.get(i).split(":");
            if(s[1].equals("start")){
                if(!stack.isEmpty()){
                    ret[stack.peek()] += Integer.parseInt(s[2]) - pre;
                }
                stack.push(Integer.parseInt(s[0]));
                pre = Integer.parseInt(s[2]);
            }
            else {
                ret[stack.peek()] += Integer.parseInt(s[2]) - pre + 1;
                stack.pop();
                pre = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return ret;
    }
}