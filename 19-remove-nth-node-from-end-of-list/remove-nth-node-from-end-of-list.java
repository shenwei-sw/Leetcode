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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        ListNode first = pre;
        for(int i = 0; i < n; i++){
            if(first != null) first = first.next;
            else return null;
        }
        while(first.next != null){
            cur = cur.next;
            first = first.next;
        }
        cur.next = cur.next.next;
        return pre.next;
    }
}