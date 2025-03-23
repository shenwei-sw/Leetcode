class Solution {
    public String countAndSay(int n) {
        if(n < 1) return "";
        if(n == 1) return "1";
        String str = "1";
        for(int i = 0; i < n - 1; i++){
            str = count(str);
        }
        return str;
    }

    public String count(String str){
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int i = 0;
        for(i = 1; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(start)){
                sb.append(i - start);
                sb.append(str.charAt(start));
                start = i;
            }
        }
        sb.append(i - start);
        sb.append(str.charAt(start));
        return sb.toString();
    }
}