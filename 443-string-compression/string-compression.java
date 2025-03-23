class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int start = 0;
        for(int i = 1; i <= chars.length; i++){
            if((i == chars.length && start < chars.length) ||(i < chars.length && chars[i] != chars[start])){
                chars[index++] = chars[start];
                if(i - start > 1){
                    for(char ch : Integer.toString(i - start).toCharArray()){
                        chars[index++] = ch; 
                    }
                }
                start = i;
            }
        }
        return index;
    }
}