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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Map<Integer, List<Integer>> map = new HashMap<>();
        TreeNode cur = root;
        int col = 0;
        Queue<TreeNode> queue_node = new LinkedList<>();
        Queue<Integer> queue_col = new LinkedList<>();
        queue_node.offer(cur);
        queue_col.offer(col);
        while(!queue_node.isEmpty()){
            cur = queue_node.poll();
            col = queue_col.poll();
            if(cur != null){
                if(!map.containsKey(col)){
                    map.put(col, new LinkedList<>());
                }
                map.get(col).add(cur.val);
                queue_node.offer(cur.left);
                queue_col.offer(col - 1);
                queue_node.offer(cur.right);
                queue_col.offer(col + 1);
            }
        }
        List<Integer> sorted_col = new LinkedList<>(map.keySet());
        Collections.sort(sorted_col);
        for(int key : sorted_col){
            ret.add(map.get(key));
        }
        return ret;
    }
}