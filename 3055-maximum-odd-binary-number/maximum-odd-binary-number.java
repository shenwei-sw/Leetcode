class Solution {
    public String maximumOddBinaryNumber(String s) {
        int len = s.length();
        int numOnes = 0;
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(ch == '1') numOnes++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numOnes - 1; i++){
            sb.append('1');
        }
        for(int i = 0; i < len - numOnes; i++){
            sb.append("0");
        }
        if(numOnes > 0) sb.append("1");
        else sb.append("0");
        return sb.toString();
    }
}