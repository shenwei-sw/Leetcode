class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        char[] array = s.toCharArray();
        int len = s.length();
        int j = 0;
        for(int i = 0; i < len; i++, j++){
            array[j] = array[i];
            if (j == 0 || array[j] != array[j - 1]) {
                stack.push(1);
            }
            else {
                int increment = stack.pop() + 1;
                if(increment == k){
                    j = j - k;
                }
                else {
                    stack.push(increment);
                }
            }
        }
        return new String(array, 0, j);
    }
}