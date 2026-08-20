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
    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    public void dfs(TreeNode node, int max){
        if(node.val >= max){
            count++;
        }

        if(node.left != null){
            dfs(node.left, Math.max(node.val, max));
        }

        if(node.right != null){
            dfs(node.right, Math.max(node.val, max));
        }
    }
}