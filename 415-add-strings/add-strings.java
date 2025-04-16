class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(n1 >= 0 || n2 >= 0 || carry > 0){
            int c1 = n1 >= 0? num1.charAt(n1) - '0' : 0;
            int c2 = n2 >= 0? num2.charAt(n2) - '0' : 0;
            int sum = c1 + c2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            n1--;
            n2--;
        }
        return sb.reverse().toString();
    }
}