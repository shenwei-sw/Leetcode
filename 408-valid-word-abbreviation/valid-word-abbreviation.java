class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int lenw = word.length();
        int lena = abbr.length();
        int ia = 0;
        int iw = 0;
        while(ia < lena && iw < lenw){
            char ch = abbr.charAt(ia);
            if(ch == word.charAt(iw)){
                ia++;
                iw++;
            }
            else if(ch > '0' && ch <= '9'){
                int len = 0;
                while(ia < lena && isDigit(abbr.charAt(ia))){
                    len = len * 10 + abbr.charAt(ia) - '0';
                    ia++;
                }
                iw += len;
            }
            else return false;
        }
        return ia == lena && iw == lenw;
    }

    public boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
}