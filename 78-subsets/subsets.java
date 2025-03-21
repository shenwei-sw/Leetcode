class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if(nums == null || nums.length == 0) return ret;    
        dfs(nums, new LinkedList<>(), 0, ret);
        return ret;
    }

    public void dfs(int[] nums, List<Integer> list, int index, List<List<Integer>> ret){
        ret.add(new LinkedList<>(list));

        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            dfs(nums, list, i + 1, ret);
            list.remove(list.size() - 1);
        }
    }
}