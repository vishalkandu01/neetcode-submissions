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
    int diameter = 0;

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;

        diameter = Math.max(diameter, leftHeight + rightHeight - 2);

        return Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}
