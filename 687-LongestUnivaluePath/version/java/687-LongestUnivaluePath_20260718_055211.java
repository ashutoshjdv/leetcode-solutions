// Last updated: 7/18/2026, 5:52:11 AM
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
17
18    int answer = 0;
19
20    public int longestUnivaluePath(TreeNode root) {
21        int compute = helper(root);
22
23        return answer;
24    }
25
26    public int helper(TreeNode node) {
27
28        if(node == null) return 0;
29
30        int left = helper(node.left);
31        int right = helper(node.right);
32
33        if(node.left != null && node.right != null && node.val == node.left.val && node.val == node.right.val) {
34            answer = Math.max(answer, 2 + left + right);
35            return 1+ Math.max(left, right);
36        } else if(node.left != null && node.val == node.left.val) {
37            answer = Math.max(answer, 1 + left);
38            return 1+left;
39        } else if(node.right != null && node.val == node.right.val) {
40            answer = Math.max(answer, 1 + right);
41            return 1+right;
42        } else {
43            return 0;
44        }
45    }
46}