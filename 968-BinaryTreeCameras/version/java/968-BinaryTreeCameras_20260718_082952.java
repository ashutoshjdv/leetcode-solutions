// Last updated: 7/18/2026, 8:29:52 AM
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
18    // static final int HAS_CAMERA = 0;
19    // static final int COVERED = 1;
20    // static final int NEEDS_CAMERA = 2;
21    public int minCameraCover(TreeNode root) {
22        int[] answer = helper(root);
23
24        if(answer[0] == 2) return 1 + answer[1];
25        return answer[1];
26    }
27
28    //i need to return cameras and gap for cameras.
29    //if i have gap = 2 i install camera.
30
31    public int[] helper(TreeNode node) {
32
33        if(node == null) return new int[]{1,0};
34
35        int[] left = helper(node.left);
36        int[] right = helper(node.right);
37
38        int[] result = new int[2];
39
40        if(left[0] == 2 || right[0] == 2) {
41            result[0] = 0;
42            result[1] = 1 + left[1] + right[1];
43        } else if(left[0] == 0 || right[0] == 0) {
44            result[0] = 1;
45            result[1] = left[1] + right[1];
46        } else {
47            result[0] = 2;
48            result[1] = left[1] + right[1];
49        }
50
51        return result;
52    }
53}