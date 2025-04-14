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
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        stack.push(root);
        map.put(root, null);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
                map.put(node.left, node);
            }
            if(node.right != null){
                stack.push(node.right);
                map.put(node.right, node);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = map.get(p);
        }

        while(!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}