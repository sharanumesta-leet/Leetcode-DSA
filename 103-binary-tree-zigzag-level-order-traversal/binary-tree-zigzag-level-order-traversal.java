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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int level = 0;
        while (!q.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode curNode = q.poll();
                curLevel.add(curNode.val);
                if (curNode.left != null)
                    q.offer(curNode.left);
                if (curNode.right != null)
                    q.offer(curNode.right);
            }
            if (level % 2 != 0)
                Collections.reverse(curLevel);
            ans.add(curLevel);
            level++;
        }

        return ans;
    }
}