/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = new ListNode(0);
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) heap.offer(lists[i]);
        }
        ListNode cur = pre;
        while(!heap.isEmpty()){
            ListNode top = heap.poll();
            cur.next = top;
            if(top.next != null){
                heap.offer(top.next);
            }
            cur = cur.next;
        }
        return pre.next;
    }
}