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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(nodes == null ||nodes.length == 0) return null;
        if(nodes.length == 1) return nodes[0];

        return dfs(root, nodes);       
    }

    public TreeNode dfs(TreeNode node, TreeNode[] nodes){
        if(node == null) return null;
        for(TreeNode n : nodes){
            if (n == node) return node;
        }
        TreeNode left = dfs(node.left, nodes);
        TreeNode right = dfs(node.right, nodes);
        if(left != null && right != null) return node;
        else if(left != null) return left;
        else return right;
    }
}