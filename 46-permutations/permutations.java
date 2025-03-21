class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        dfs(nums, new ArrayList<Integer>(), ret);
        return ret;
    }

    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> ret){
        if(list.size() == nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                dfs(nums, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }
}