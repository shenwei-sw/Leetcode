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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = dfs(root, p, q);

        if(ret == p){
            return check(p, q) ? p : null;
        }

        if(ret == q){
            return check(q, p) ? q : null;
        }

        return ret;
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null || node == p || node == q) return node;

        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if(left != null && right != null) return node;
        else if(left != null) return left;
        return right;
    }

    public boolean check(TreeNode node, TreeNode target){
        if(node == null) return false;

        if(node == target) return true;

        return check(node.left, target) || check(node.right, target);
    }
}