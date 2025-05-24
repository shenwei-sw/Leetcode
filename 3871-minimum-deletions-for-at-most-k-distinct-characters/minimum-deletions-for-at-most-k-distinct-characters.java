class Solution {
    public int minDeletion(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        if(map.size() <= k) return 0;

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int count = 0;
        int size = list.size();
        int i = 0;
        while(size > k){
            count += list.get(i);
            i++;
            size--;           
        }
        return count;
    }
}