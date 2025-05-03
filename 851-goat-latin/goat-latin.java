class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder as = new StringBuilder();
        as.append('a');
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            if(set.contains(str.charAt(0))){
                sb.append(str);
            }
            else{
                sb.append(str.substring(1));
                sb.append(str.charAt(0));
            }
            sb.append("ma");
            sb.append(as);
            as.append('a');
            if(i != words.length - 1) sb.append(' ');
        }
        return sb.toString();
    }
}