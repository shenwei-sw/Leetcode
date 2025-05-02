class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            String t = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double q = values[i];

            if(!map.containsKey(t)){
                map.put(t, new HashMap<>());
            }
            map.get(t).put(b, q);
            if(!map.containsKey(b)){
                map.put(b, new HashMap<>());
            }
            map.get(b).put(t, 1 / q);
        }

        double[] ret = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String s = queries.get(i).get(0);
            String t = queries.get(i).get(1);

            if(!map.containsKey(s) || !map.containsKey(t)){
                ret[i] = -1.0;
            }
            else if (s == t){
                ret[i] = 1.0;
            }
            else {
                ret[i] = dfs(s, t, map, new HashSet<String>(), 1.0);
            }        
        }
        return ret;
    }

    public double dfs(String s, String t, Map<String, Map<String, Double>> map, Set<String> visited, double q){
        visited.add(s);
        double ret = -1.0;

        Map<String, Double> neighbors = map.get(s);
        if(neighbors.containsKey(t)){
            ret = q * neighbors.get(t);
        }
        else {
            for(Map.Entry<String, Double> entry : neighbors.entrySet()){
                String nextNode = entry.getKey();
                if(visited.contains(nextNode)) continue;
                ret = dfs(nextNode, t, map, visited, q * entry.getValue());
                if(ret != -1.0) break;
            }
        }
        visited.remove(s);
        return ret;
    }
}