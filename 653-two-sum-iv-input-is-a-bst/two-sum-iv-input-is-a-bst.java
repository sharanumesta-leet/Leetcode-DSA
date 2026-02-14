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
    public boolean dfs(Set<Integer> set, TreeNode node, int k) {
        if (node == null)
            return false;
        int val = node.val;
        int req = k - val;
        if (set.contains(req))
            return true;
        set.add(val);
        return dfs(set, node.left, k) || dfs(set, node.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(set, root, k);
    }
}