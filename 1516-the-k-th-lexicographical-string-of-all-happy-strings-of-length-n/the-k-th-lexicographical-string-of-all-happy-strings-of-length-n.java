class Solution {
    public String getHappyString(int n, int k) {
        if(n <= 0 || k <= 0) return "";
        List<String> ret = new LinkedList<>();
        dfs(n, new StringBuilder(), ret);
        if(ret.size() < k) return "";
        return ret.get(k - 1);
    }

    public void dfs(int n, StringBuilder sb, List<String> ret){
        if(sb.length() == n){
            ret.add(new String(sb));
            return;
        }

        for(char ch = 'a'; ch <= 'c'; ch++){
            if(!sb.isEmpty() && ch == sb.charAt(sb.length() - 1)) continue;
            sb.append(ch);
            dfs(n, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}