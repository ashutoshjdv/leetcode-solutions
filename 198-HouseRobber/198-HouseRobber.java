// Last updated: 7/5/2026, 2:36:05 AM
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];

        dp[nums.length + 1] = 0;
        dp[nums.length] = 0;

        for(int i=nums.length -1; i >=0; i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }

        return Math.max(dp[0], dp[1]);
    }
}