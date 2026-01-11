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
    public void DFS(TreeNode node, int val, int depth) {
        if (node == null)
            return;
        if (depth == 1) {
            TreeNode leftSub = node.left;
            TreeNode rightSub = node.right;
            TreeNode leftNewNode = new TreeNode(val);
            TreeNode rightNewNode = new TreeNode(val);

            node.left = leftNewNode;
            node.right = rightNewNode;

            leftNewNode.left = leftSub;
            rightNewNode.right = rightSub;
            return;
        }
        DFS(node.left, val, depth - 1);
        DFS(node.right, val, depth - 1);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;

        }
        DFS(root, val, depth - 1);
        return root;
    }
}