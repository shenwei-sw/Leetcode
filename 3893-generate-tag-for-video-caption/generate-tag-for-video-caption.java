class Solution {
    public String generateTag(String caption) {
        String[] strArray = caption.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        int index = 1;
        for(String str : strArray){
            if(str.length() == 0 || str == " ") continue;
            if(index != 1){
                str = str.substring(0, 1).toUpperCase() + str.substring(1);
            }
            if(index + str.length() > 100){
                sb.append(str.substring(0, 100 - index));
                return sb.toString();
            }
            else{
                sb.append(str);
                index += str.length();
            }            
        }
        return sb.toString();
    }
}