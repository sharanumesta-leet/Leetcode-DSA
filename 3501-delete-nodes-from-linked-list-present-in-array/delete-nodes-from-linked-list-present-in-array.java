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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0, head);
        ListNode newHead = dummy;
        ListNode temp = head;

        for (int num : nums)
            set.add(num);

        while (temp != null) {
            if (set.contains(temp.val))
                dummy.next = temp.next;
            else
                dummy = temp;
            temp = temp.next;
        }
        return newHead.next;
    }
}