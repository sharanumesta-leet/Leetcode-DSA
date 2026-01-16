/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void insertNode(TreeNode node, TreeNode newNode) {
        int val = newNode.val;
        int curNodeval = node.val;
        if (node.left == null && val < curNodeval) {
            node.left = newNode;
            return;
        } else if (node.right == null && val > curNodeval) {
            node.right = newNode;
            return;
        } else if (val < curNodeval)
            insertNode(node.left, newNode);
        else if (val > curNodeval)
            insertNode(node.right, newNode);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int n = preorder.length;
        for (int i = 1; i < n; i++) {
            TreeNode newNode = new TreeNode(preorder[i]);
            insertNode(root, newNode);
        }
        return root;
    }
}