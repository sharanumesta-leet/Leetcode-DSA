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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = head;
        ListNode pre = head;
        ListNode newHead = dummy;
        ListNode temp = head.next;

        while (temp != null) {
            int sum = 0;
            while (temp.val != 0) {
                sum += temp.val;
                temp = temp.next;
            }
            dummy.val = sum;
            pre = dummy;
            dummy = dummy.next;
            temp = temp.next;
        }
        pre.next = null;
        return newHead;
    }
}