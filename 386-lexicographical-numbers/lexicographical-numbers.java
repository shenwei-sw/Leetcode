class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new LinkedList<>();

        for(int i = 1; i <= 9; i++){
            generate(i, n, ret);
        }
        return ret;
    }

    public void generate(int cur, int limit, List<Integer> ret){
        if(cur > limit) return;
        ret.add(cur);
        for(int i = 0; i <= 9; i++){
            int next = cur * 10 + i;
            if(next <= limit){
                generate(next, limit, ret);
            }
            else break;
        }
    }
}