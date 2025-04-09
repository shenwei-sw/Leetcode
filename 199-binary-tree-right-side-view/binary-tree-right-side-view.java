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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> res, int level){
        if(res.size() == level){
            res.add(node.val);
        }

        if(node.right != null) dfs(node.right, res, level + 1);
        if(node.left != null) dfs(node.left, res, level + 1);
    }
}