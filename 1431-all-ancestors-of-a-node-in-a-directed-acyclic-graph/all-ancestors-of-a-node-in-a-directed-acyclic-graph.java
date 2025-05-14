class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer>[] nlist = new LinkedList[n];
        for(int i = 0; i < n; i++){
            nlist[i] = new LinkedList<>();
        }

        for(int[] edge : edges){
            nlist[edge[1]].add(edge[0]);
        }
       
        for(int i = 0; i < n; i++){
            List<Integer> ancestors = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            dfs(i, nlist, visited);
            for(int node = 0; node < n; node++){
                if(node == i) continue;
                if(visited.contains(node)) ancestors.add(node);
            }
            ret.add(ancestors);
        }

        return ret;
    }

    public void dfs(int node, List<Integer>[] nlist, Set<Integer> visited){
        visited.add(node);
        for(int i : nlist[node]){
            if(!visited.contains(i)){
                dfs(i, nlist, visited);
            }
        }
    }
}