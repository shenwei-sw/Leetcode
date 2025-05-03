class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for(int i = 0; i < ages.length; i++){
            count[ages[i]]++;
        }
        int ret = 0;
        for(int x = 1; x <= 120; x++){
            int agex = count[x];
            for(int y = 1; y <= 120; y++){
                int agey = count[y];
                if(0.5 * x + 7 >= y) continue;
                if(x < y) continue;
                if(y > 100 && x < 100) continue;
                ret += agex * agey;
                if(x == y) ret -= agex;
            }
        }
        return ret;
    }
}