/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        addParent(root, null);

        Set<Integer> set = new HashSet<>();
        List<Integer> ret = new LinkedList<>();
        dfs(target, k, set, ret);
        return ret;
    }

    public void dfs(TreeNode cur, int k, Set<Integer> set, List<Integer> ret){
        if(cur == null || set.contains(cur.val)) return ;
        set.add(cur.val);
        if(k == 0){
            ret.add(cur.val);
            return;
        }
        dfs(map.get(cur), k - 1, set, ret);
        dfs(cur.left, k - 1, set, ret);
        dfs(cur.right, k - 1, set, ret);
    }

    public void addParent(TreeNode node, TreeNode par){
        if(node == null) return;
        map.put(node, par);
        addParent(node.left, node);
        addParent(node.right, node);
    }
}