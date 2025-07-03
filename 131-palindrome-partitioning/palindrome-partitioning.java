class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<>();
        dfs(s, 0, new LinkedList<>(), ret);
        return ret;
    }

    public void dfs(String s, int pos, List<String> list, List<List<String>> ret){
        if(s.length() == pos){
            ret.add(new LinkedList<>(list));
            return;
        }
        for(int i = pos; i < s.length(); i++){
            String sub = s.substring(pos, i + 1);
            if(isPalindrome(sub)){
                list.add(sub);
                dfs(s, i + 1, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}