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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode next;
        ListNode cur = preHead;
        while(cur.next != null && cur.next.next != null){
            next = cur.next;
            ListNode start = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = next;
            next.next = start;
            cur = next;
        }
        return preHead.next;
    }
}