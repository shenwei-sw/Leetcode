class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < numCourses; i++){
            graph.put(i, new LinkedList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int cur = prerequisites[i][0];
            graph.get(pre).add(cur);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] instack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(dfs(graph, i, visited, instack)) return false;
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, int pre, boolean[] visited, boolean[] instack){    
        if(instack[pre]) return true;
        if(visited[pre]) return false;
        visited[pre] = true;
        instack[pre] = true;
        for(int cur : graph.get(pre)){
            if(dfs(graph, cur, visited, instack)) return true;
        }
        instack[pre] = false;
        return false;
    }
}