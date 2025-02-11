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

        Queue<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        boolean isReverse = false;

        while(!list.isEmpty()){
            int size = list.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = list.poll();
                if(isReverse) level.addFirst(node.val); 
                else level.add(node.val);
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
            }
            ret.add(level);
            isReverse = !isReverse;
        }
        return ret;
    }
}