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

function rotateRight(head: ListNode | null, k: number): ListNode | null {
    if (head === null || head.next === null) return head;

    let temp: ListNode | null = head;
    let start: ListNode | null = head;
    let startPre: ListNode | null = null;
    let tail: ListNode | null = null;

    let n: number = 0;
    while (temp !== null) {
        tail = temp;
        temp = temp.next;
        n++;
    }
    temp = head;
    let shift: number = k % n;
    if (shift === 0) return head;

    for (let i = 0; i < n - shift; i++) {
        startPre = start;
        start = start.next;
    }

    tail.next = head;
    startPre.next = null;
    return start;
};