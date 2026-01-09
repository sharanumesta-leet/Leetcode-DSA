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
    static class Ans {
        TreeNode node;
        int height;

        public Ans(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public Ans helper(TreeNode node) {
        if (node == null)
            return new Ans(null, 0);
        Ans left = helper(node.left);
        Ans right = helper(node.right);
        if (left.height > right.height)
            return new Ans(left.node, left.height + 1);
        else if (left.height < right.height)
            return new Ans(right.node, right.height + 1);
        else
            return new Ans(node, left.height + 1);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;
    }
}