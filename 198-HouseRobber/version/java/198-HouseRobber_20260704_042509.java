// Last updated: 7/4/2026, 4:25:09 AM
1class Solution {
2    public int rob(int[] nums) {
3        int[] dp = new int[nums.length + 2];
4
5        dp[nums.length + 1] = 0;
6        dp[nums.length] = 0;
7
8        for(int i=nums.length -1; i >=0; i--) {
9            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
10        }
11
12        return Math.max(dp[0], dp[1]);
13    }
14}