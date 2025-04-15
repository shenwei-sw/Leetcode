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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode node, int low, int high){
        if(node == null) return;
        int val = node.val;
        if(val < low){
            dfs(node.right, low, high);
        }
        else if (val > high){
            dfs(node.left, low, high);
        }
        else {
            sum += val;
            dfs(node.left, low, high);
            dfs(node.right, low, high);
        }
    }
}