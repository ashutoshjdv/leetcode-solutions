// Last updated: 7/5/2026, 2:35:42 AM
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+2];

        dp[cost.length+1] = 0;
        dp[cost.length] = 0;

        for(int i = cost.length -1; i >=0 ; i--) {
            dp[i] = Math.min(cost[i] + dp[i+1], cost[i] + dp[i+2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    public int helper(int i, int[] cost) {
        if(i >= cost.length) return 0;

        return Math.min(cost[i] + helper(i+1, cost), cost[i] + helper(i+2, cost));
    }
}