class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(coins, amount, map);        
    }

    public int dfs(int[] coins, int amount, Map<Integer, Integer> map){
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(map.containsKey(amount)) return map.get(amount);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int ret = dfs(coins, amount - coins[i], map);
            if(ret >= 0 && ret < min){
                min = ret + 1;
            }
        }
        min = min == Integer.MAX_VALUE? -1 : min;
        map.put(amount, min);
        return map.get(amount);
    }
}