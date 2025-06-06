class Solution {
    public int nextGreaterElement(int n) {
        char[] str = Integer.toString(n).toCharArray();
        int len = str.length;
        for(int i = len - 2; i >= 0; i--){
            if(str[i] < str[i + 1]){
                int j = len - 1;
                while(j >= 0 && str[j] <= str[i]){
                    j--;
                }
                swap(str, i, j);
                reverse(str, i + 1, len - 1);
                try{
                    return Integer.parseInt(new String(str));
                } catch (Exception e){
                    return -1;
                }
            }
        }
        return -1;
    }

    private void swap(char[] str, int left, int right){
        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    }

    private void reverse(char[] str, int start, int end){
        while(start < end){
            swap(str, start, end);
            start++;
            end--;
        }
    }
}