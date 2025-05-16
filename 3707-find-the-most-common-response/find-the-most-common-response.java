class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();
        int len = responses.size();
        for(int i = 0; i < len; i++){
            Set<String> set = new HashSet<>();
            for(String str : responses.get(i)){
                set.add(str);
            }
            for(String str : set){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int max = 0;
        String ret = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(max < entry.getValue()){
                ret = entry.getKey();
                max = entry.getValue();
            }
            else if(max == entry.getValue()){
                if(ret.compareTo(entry.getKey()) > 0){
                    ret = entry.getKey();
                }
            }
        }
        return ret;
    }
}