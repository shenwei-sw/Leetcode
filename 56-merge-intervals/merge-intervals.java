class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ret = new LinkedList<>();
        int[] pre = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(pre[1] < cur[0]){
                ret.add(pre);
                pre = cur;
            }
            else {
                pre[1] = Math.max(pre[1], cur[1]);
            }
        }
        ret.add(pre);
        return ret.toArray(new int[ret.size()][]);
    }
}