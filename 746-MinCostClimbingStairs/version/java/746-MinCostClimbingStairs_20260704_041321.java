// Last updated: 7/4/2026, 4:13:21 AM
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int[] dp = new int[cost.length+2];
4
5        dp[cost.length+1] = 0;
6        dp[cost.length] = 0;
7
8        for(int i = cost.length -1; i >=0 ; i--) {
9            dp[i] = Math.min(cost[i] + dp[i+1], cost[i] + dp[i+2]);
10        }
11        return Math.min(dp[0], dp[1]);
12    }
13
14    public int helper(int i, int[] cost) {
15        if(i >= cost.length) return 0;
16
17        return Math.min(cost[i] + helper(i+1, cost), cost[i] + helper(i+2, cost));
18    }
19}