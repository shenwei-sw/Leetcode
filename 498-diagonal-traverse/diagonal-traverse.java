class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0) return null;
        int[] ret = new int[mat.length * mat[0].length];
        int index = 0;
        boolean isReversed = false;
        for(int i = 0; i < mat.length; i++){
            List<Integer> list = shift(mat, i, 0, isReversed);
            for(Integer k : list){
                ret[index++] = k;
            }
            isReversed = !isReversed;
        }
        for(int i = 1; i < mat[0].length; i++){
            List<Integer> list = shift(mat, mat.length - 1, i, isReversed);
            for(Integer k : list){
                ret[index++] = k;
            }
            isReversed = !isReversed;
        }
        return ret;
    }

    public List<Integer> shift(int[][] mat, int x, int y, boolean isReversed){
        List<Integer> list = new LinkedList<>();
        for(int i = x, j = y; i >= 0 && j <= mat[0].length - 1; i--, j++){
            if(isReversed){
                list.addFirst(mat[i][j]);
            }
            else {
                list.add(mat[i][j]);
            }
        }
        return list;
    }
}