// Last updated: 6/26/2026, 8:54:32 AM
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

    int max_diameter =0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null ) return 0;

        diameter(root);

        return max_diameter;
    }

    public int diameter(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = diameter(node.left);

        int rightHeight = diameter(node.right);

        max_diameter = Math.max(max_diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}