class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = lo; i <= hi; i++){
            map.put(i, calculateSteps(i));
        }
        List<Integer> ret = new ArrayList<>(map.keySet());
        Collections.sort(ret, (a, b) -> {
            if(map.get(a) != map.get(b)){
                return map.get(a) - map.get(b);
            }
            return a - b;
        });
        return ret.get(k - 1);
    }

    public int calculateSteps(int num){
        int steps = 0;
        while(num != 1){
            if(num % 2 == 0)
                num /= 2;
            else 
                num = 3 * num + 1;
            steps++;
        }
        return steps;
    }
}