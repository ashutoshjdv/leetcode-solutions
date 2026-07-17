// Last updated: 7/18/2026, 5:15:53 AM
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
17    int answer = Integer.MIN_VALUE;
18
19    public int maxPathSum(TreeNode root) {
20         int compute = helper(root);
21
22         return answer;
23    }
24
25
26    public int helper(TreeNode node) {
27
28        if(node == null) return 0;
29
30        int left = Math.max(0, helper(node.left));
31        int right = Math.max(0, helper(node.right));
32
33        this.answer = Math.max(this.answer, node.val + left + right);
34
35        return node.val + Math.max(left, right);
36
37    }
38
39
40    
41    // public int[] helper(TreeNode node) {
42
43    //     if(node == null) return new int[]{0,0,0};
44
45    //     int[] left = helper(node.left);
46    //     int[] right = helper(node.right);
47
48    //     int[] result = new int[3];
49
50    //     //dont consider this node as parent node
51    //     result[0] = Math.max(left[0], right[0]) + node.val;
52
53    //     //consider this as parent node
54    //     result[1] = node.val + left[0] + right[0];
55
56    //     //dont include this node in path
57    //     result[2] = Math.max(left[1], right[1]);
58
59    //     return result;
60    // }
61}