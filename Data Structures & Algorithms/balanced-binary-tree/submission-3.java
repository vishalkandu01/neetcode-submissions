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
    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -2;
        }

        return Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight <= -1 || rightHeight <= -1) {
            return false;
        }

        return Math.abs(leftHeight - rightHeight) <= 1;
    }
}
