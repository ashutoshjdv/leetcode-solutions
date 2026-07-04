// Last updated: 7/4/2026, 5:37:27 PM
1class Solution {
2    int[][] dp;
3    int[] nums;
4    public int lengthOfLIS(int[] nums) {
5        int n = nums.length;
6
7        this.nums = nums;
8
9        this.dp = new int[n+1][n+1];
10
11        for(int[] row : dp) {
12            Arrays.fill(row, -1);
13        }
14
15        return helper();
16    }
17
18    public int helper() {
19
20        for(int i=0; i<nums.length+1;i++) {
21            dp[nums.length][i] = 0;
22        }
23
24        for(int i = nums.length -1; i>=0; i--) {
25            for (int prevIndex = i - 1; prevIndex >= -1; prevIndex--) {
26                int take =0;
27                int col = prevIndex + 1;
28
29                if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
30                    take = 1 + dp[i + 1][i + 1];
31                }
32
33                int skip = dp[i + 1][col];
34
35                dp[i][prevIndex+1] = Math.max(take, skip);
36            }
37        }
38
39        return dp[0][0];
40    }
41}