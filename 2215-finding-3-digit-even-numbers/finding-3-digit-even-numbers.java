class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int len = digits.length;
        for(int i = 0; i < len; i++){
            int d1 = digits[i];
            if(digits[i] == 0) continue;
            for(int j = 0; j < len; j++){
                int d2 = digits[j];
                for(int k = 0; k < len; k++){
                    int d3 = digits[k];
                    if(i == j || i == k || j == k) continue;
                    if(d3 % 2 == 0){
                        set.add(d1 * 100 + d2 * 10 + d3);
                    }
                }
            }
        }
        List<Integer> ret = new LinkedList<>(set);
        Collections.sort(ret);
        int[] result = new int[ret.size()];
        for(int i = 0; i < ret.size(); i++){
            result[i] = ret.get(i);
        }
        return result;
    }
}