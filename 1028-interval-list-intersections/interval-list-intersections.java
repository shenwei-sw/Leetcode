class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;
        int cur1 = 0;
        int cur2 = 0;
        List<int[]> ret = new LinkedList<>();
        while(cur1 < len1 && cur2 < len2){
            if(firstList[cur1][1] < secondList[cur2][0]){
                cur1++;
            }
            else if (firstList[cur1][0] > secondList[cur2][1]){
                cur2++;
            }
            else if(firstList[cur1][1] < secondList[cur2][1]){
                ret.add(new int[]{Math.max(firstList[cur1][0], secondList[cur2][0]), firstList[cur1][1]});
                cur1++;
            }
            else {
                ret.add(new int[] {Math.max(firstList[cur1][0], secondList[cur2][0]), secondList[cur2][1]});
                cur2++;
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }
}