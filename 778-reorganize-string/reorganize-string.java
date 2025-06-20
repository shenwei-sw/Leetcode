class Solution {
    public String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for(char ch : s.toCharArray()){
            charCounts[ch - 'a']++;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int i = 0; i < 26; i++){
            if(charCounts[i] > 0){
                heap.offer(new int[] {i + 'a', charCounts[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()){
            int[] first = heap.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]){
                sb.append((char)first[0]);
                if(--first[1] > 0){
                    heap.offer(first);
                }
            }
            else {
                if(heap.isEmpty()) return "";

                if(sb.charAt(sb.length() - 1) == first[0]){
                    int[] second = heap.poll();
                    sb.append((char)second[0]);
                    if(--second[1] > 0){
                        heap.offer(second);
                    }
                    heap.offer(first);
                }
            }
        }

        return sb.toString();
    }
}