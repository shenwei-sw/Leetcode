class Solution {
    public int maximumSwap(int num) {
        char[] charray = Integer.toString(num).toCharArray();
        int len = charray.length;
        int maxIndex = -1;
        int smallIndex = -1;
        int bigIndex = -1;
        for(int i = len - 1; i >= 0; i--){
            if(maxIndex == -1 || charray[i] > charray[maxIndex]){
                maxIndex = i;
            }
            else if(charray[i] < charray[maxIndex]){
                smallIndex = i;
                bigIndex = maxIndex;
            }
        }

        if(smallIndex != -1 && bigIndex != -1){
            char temp = charray[smallIndex];
            charray[smallIndex] = charray[bigIndex];
            charray[bigIndex] = temp;
        }
        return Integer.parseInt(new String(charray));
    }
}