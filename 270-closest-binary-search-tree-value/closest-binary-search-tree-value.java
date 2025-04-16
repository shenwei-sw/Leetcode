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
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        int ret = root.val;
        double min = Math.abs(root.val - target);
        while(root != null){
            if(Math.abs(root.val - target) < min || (Math.abs(root.val - target) == min && ret > root.val)){
                min = Math.abs(root.val - target);
                ret = root.val;
            }
            if(root.val < target){
                root = root.right;
            }
            else 
                root = root.left;
        }
        return ret;
    }
}