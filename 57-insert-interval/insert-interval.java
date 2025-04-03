class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int i = 0;
        List<int[]> ret = new ArrayList<>();
        
        while(i < len && intervals[i][1] < newInterval[0]){
            ret.add(intervals[i]);
            i++;
        }
        int[] pre = newInterval;
        int[] cur;
        while(i < len){
            cur = intervals[i];
            if(pre[1] < cur[0]){
                ret.add(pre);
                pre = cur;
            }
            else {
                pre[0] = Math.min(pre[0], cur[0]);
                pre[1] = Math.max(pre[1], cur[1]);
            }
            i++;
        }
        ret.add(pre);
        return ret.toArray(new int[ret.size()][]);
    }
}