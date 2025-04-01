class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> pmap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> fmap = new HashMap<>();
        for(int i = 0; i < pairs.length; i++){
            pmap.put(pairs[i][0], pairs[i][1]);
            pmap.put(pairs[i][1], pairs[i][0]);
        }

        for(int i = 0; i < preferences.length; i++){
            fmap.put(i, new HashMap<Integer, Integer>());
            for(int j = 0; j < preferences[i].length; j++){
                fmap.get(i).put(preferences[i][j], j);
            }
        }

        int ret = 0;
        for(int i = 0; i < n; i++){
            int pair = pmap.get(i);
            int[] friends = preferences[i];
            for(int j = 0; j < friends.length; j++){
                if(friends[j] == pair) break;
                int fpair = pmap.get(friends[j]);
                if(fmap.get(friends[j]).get(i) < fmap.get(friends[j]).get(fpair)){
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }
}