/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;

        dfs(root, 0, ret);
        return ret;
    }

    public void dfs(TreeNode node, int level, List<List<Integer>> ret){
        if(level == ret.size())
            ret.add(new ArrayList<>());
        
        if(level % 2 == 0) ret.get(level).add(node.val);
        else ret.get(level).add(0, node.val);

        if(node.left != null) dfs(node.left, level + 1, ret);
        if(node.right != null) dfs(node.right, level + 1, ret);
    }
}