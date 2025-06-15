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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;

        Map<Integer, List<Integer>> map = new HashMap<>();
        PriorityQueue<IndexNode> queue = new PriorityQueue<>((a, b) -> {
                if(a.row == b.row){
                    return a.t.val - b.t.val;
                }
                else {
                    return a.row - b.row;
                }
            });
        int min = 0;
        int max = 0;
        queue.offer(new IndexNode(0, 0, root));
        while(!queue.isEmpty()){
            IndexNode node = queue.poll();
            int row = node.row;
            int ver = node.col;
            TreeNode tn = node.t;

            if(!map.containsKey(ver)){
                map.put(ver, new LinkedList<>());
            }
            map.get(ver).add(tn.val);          
            if(tn.left != null){
                queue.offer(new IndexNode(row + 1, ver - 1, tn.left));
                min = Math.min(min, ver - 1);
            }
            if(tn.right != null){
                queue.offer(new IndexNode(row + 1, ver + 1, tn.right));
                max = Math.max(max, ver + 1);
            }
        }

        for(int i = min; i <= max; i++){
            ret.add(map.get(i));
        }
        
        return ret;
    }

    public class IndexNode{
        int row, col;
        TreeNode t;
        public IndexNode(int r, int c, TreeNode t){
            row = r;
            col = c;
            this.t = t;
        }
    }
}