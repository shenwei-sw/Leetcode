class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length() + 1];
        queue.offer(0);
        while(!queue.isEmpty()){
            int start = queue.poll();
            if(start == s.length()) return true;
            
            for(int end = start + 1; end <= s.length(); end++){
                if(visited[end]) continue;

                if(set.contains(s.substring(start, end))){
                    queue.offer(end);
                    visited[end] = true;
                }
            }
        }
        return false;
    }
}