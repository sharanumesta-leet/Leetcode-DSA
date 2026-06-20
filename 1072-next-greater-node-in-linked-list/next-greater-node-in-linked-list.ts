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

function nextLargerNodes(head: ListNode | null): number[] {
    let cur: ListNode = head;
    let count: number = 0;
    while (cur !== null) {
        count++;
        cur = cur.next;
    }

    let n: number = count;
    let ans: number[] = new Array(n).fill(0);
    let st: number[][] = [];

    cur = head;
    let idx: number = 0;
    while (cur !== null) {
        let curVal: number = cur.val;
        while (st.length !== 0 && curVal > st[st.length - 1][0]) {
            let i = st.pop()[1];
            ans[i] = curVal;
        }
        st.push([curVal, idx])
        cur = cur.next;
        idx++;
    }
    return ans;
};