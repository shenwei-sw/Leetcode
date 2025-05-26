class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> adjacent = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int len = accounts.size();

        for(List<String> account : accounts){
            int size = account.size();
            String firstEmail = account.get(1);
            for(int i = 2; i < size; i++){
                String email = account.get(i);
                if(!adjacent.containsKey(firstEmail)){
                    adjacent.put(firstEmail, new LinkedList<String>());
                }
                adjacent.get(firstEmail).add(email);
                if(!adjacent.containsKey(email)){
                    adjacent.put(email, new LinkedList<>());
                }
                adjacent.get(email).add(firstEmail);
            }
        }

        List<List<String>> ret = new LinkedList<>();
        for(List<String> account : accounts){
            String name = account.get(0);
            String firstEmail = account.get(1);

            if(!visited.contains(firstEmail)){
                List<String> mergedAccount = new LinkedList<>();
                mergedAccount.add(name);

                dfs(mergedAccount, firstEmail, adjacent, visited);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                ret.add(mergedAccount);
            }
        }
        return ret;
    }

    public void dfs(List<String> mergedAccount, String email, Map<String, List<String>> adjacent, Set<String> visited){
        visited.add(email);
        mergedAccount.add(email);

        if(!adjacent.containsKey(email)) return ;

        for(String neighbor : adjacent.get(email)){
            if(!visited.contains(neighbor)){
                dfs(mergedAccount, neighbor, adjacent, visited);
            }
        }
    }
}