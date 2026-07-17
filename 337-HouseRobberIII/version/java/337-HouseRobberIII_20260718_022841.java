// Last updated: 7/18/2026, 2:28:41 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int rob(TreeNode root) {
18        int[] answer = helper(root);
19        return Math.max(answer[0], answer[1]);
20    }
21
22    public int[] helper(TreeNode node) {
23
24        if(node == null) return new int[]{0,0};
25
26        int[] left = helper(node.left);
27        int[] right = helper(node.right);
28
29        int[] result = new int[2];
30
31        //dont rob the node
32        result[0] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
33
34        //rob the node
35        result[1] = node.val + left[0] + right[0];
36
37        return result;
38    }
39}