/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function pairSum(head: ListNode | null): number {
    let slow: ListNode = head;
    let fast: ListNode = head;
    let first: ListNode = head;

    while (fast !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    let second: ListNode = slow;

    let temp: ListNode = slow;
    let revSec: ListNode = null;

    while (temp !== null) {
        let next: ListNode = temp.next;
        temp.next = revSec;
        revSec = temp;
        temp = next;
    }
    second = revSec;

    let maxSum = 0;
    while (first !== null && second !== null) {
        maxSum = Math.max(maxSum, first.val + second.val);
        first = first.next;
        second = second.next;
    }
    return maxSum;
};