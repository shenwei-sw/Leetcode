class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new LinkedList<>();
        if(graph == null || graph.length == 0) return ret;
        List<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph, path, 0, graph.length - 1, ret);
        return ret;
    }

    public void dfs(int[][] graph, List<Integer> path, int cur, int target, List<List<Integer>> ret){
        if(cur == target){
            ret.add(new LinkedList<Integer>(path));
            return;
        }

        for(int node : graph[cur]){
            path.add(node);
            dfs(graph, path, node, target, ret);
            path.remove(path.size() - 1);
        }
    }
}