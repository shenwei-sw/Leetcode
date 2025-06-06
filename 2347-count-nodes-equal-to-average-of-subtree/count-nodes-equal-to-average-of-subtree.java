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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }

    private Pair<Integer, Integer> postOrder(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }

        Pair<Integer, Integer> left = postOrder(root.left);
        Pair<Integer, Integer> right = postOrder(root.right);

        int sum = left.getKey() + right.getKey() + root.val;
        int num = left.getValue() + right.getValue() + 1;

        if(root.val == sum / num){
            count++;
        }

        return new Pair(sum, num);
    }
}