class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings){
            String hashkey = hash(str);
            if(!map.containsKey(hashkey)){
                map.put(hashkey, new LinkedList<>());
            }
            map.get(hashkey).add(str);
        }
        List<List<String>> ret = new LinkedList<>();
        for(List<String> list : map.values()){
            ret.add(list);
        }
        return ret;
    }

    public String hash(String str){
        char[] chars = str.toCharArray();
        char s = chars[0];
        for(int i = 0; i < chars.length; i++){
            chars[i] = shift(chars[i], s);
        }
        String key = String.valueOf(chars);
        return key;
    }

    public char shift(char t, char s){
        return (char) ((t - s + 26) % 26 );
    }
}