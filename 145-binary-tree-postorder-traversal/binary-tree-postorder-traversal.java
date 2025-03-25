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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        dfs(root, ret);
        return ret;
    }
    public void dfs(TreeNode node, List<Integer> ret){
        if(node == null) return;
        dfs(node.left, ret);
        dfs(node.right, ret);
        ret.add(node.val);
    }
}