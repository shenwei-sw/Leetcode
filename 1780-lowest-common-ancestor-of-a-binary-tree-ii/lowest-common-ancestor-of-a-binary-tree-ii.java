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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    public int dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left, p, q);
        int right = dfs(node.right, p, q);

        int mid = (node == p || node == q)? 1 : 0;
        if(mid + left + right >= 2) lca = node;
        return mid + left + right > 0? 1 : 0;
    }
}