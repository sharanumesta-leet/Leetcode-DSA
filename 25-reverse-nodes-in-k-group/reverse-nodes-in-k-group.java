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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prevGroupTail = dummy;
        ListNode temp = head;

        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head;
        int i = 0;
        while (i < (count / k)) {
            ListNode start = null;
            ListNode end = temp;
            ListNode next = null;
            for (int j = 0; j < k; j++) {
                next = temp.next;
                temp.next = start;
                start = temp;
                temp = next;
            }
            prevGroupTail.next = start;
            prevGroupTail = end;
            i++;
        }
        prevGroupTail.next = temp;
        return dummy.next;
    }
}