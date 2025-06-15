class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int len1 = encoded1.length;
        int len2 = encoded2.length;

        int i1 = 0;
        int i2 = 0;

        int p1 = 0;
        int p2 = 0;
        
        List<List<Integer>> ret = new LinkedList<>();
        while(i1 < len1 && i2 < len2){
            int f1 = encoded1[i1][1] - p1;
            int f2 = encoded2[i2][1] - p2;

            int fre = Math.min(f1, f2);

            p1 += fre;
            p2 += fre;

            int prod = encoded1[i1][0] * encoded2[i2][0];
            int curSize = ret.size();
            if(curSize > 0 && ret.get(curSize - 1).get(0) == prod){
                fre += ret.get(curSize - 1).get(1);
                ret.remove(curSize - 1);
            }
            ret.add(Arrays.asList(prod, fre));

            if(p1 == encoded1[i1][1]){
                i1++;
                p1 = 0;
            }
            if(p2 == encoded2[i2][1]){
                i2++;
                p2 = 0;
            }
        }
        return ret;
    }
}