/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
function createBinaryTree(descriptions: number[][]): TreeNode | null {
    let set: Set<number> = new Set();
    let map: Map<number, TreeNode> = new Map();

    for (let [p, c, isLeft] of descriptions) {
        set.add(p);
        if (!map.has(p))
            map.set(p, new TreeNode(p));

        if (!map.has(c))
            map.set(c, new TreeNode(c));

        let parent: TreeNode = map.get(p);
        let child: TreeNode = map.get(c);

        if (isLeft === 1)
            parent.left = child;
        else
            parent.right = child;
    }

    for (let node of descriptions) {
        let child = node[1];
        if (set.has(child))
            set.delete(child);
    }

    let root: number = [...set][0];

    return map.get(root);
};