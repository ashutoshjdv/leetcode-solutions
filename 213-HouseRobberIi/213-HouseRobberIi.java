// Last updated: 7/5/2026, 2:36:00 AM
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums,0,n-1)), helper(Arrays.copyOfRange(nums,1,n)));
    }

    public int helper(int[] nums) {
        int[] dp = new int[nums.length + 2];

        dp[nums.length] = 0;

        dp[nums.length +1] = 0;

        for(int i=nums.length -1; i>=0;i-- ) {
            dp[i] = Math.max(dp[i+2] + nums[i], dp[i+1]);
        }

        return dp[0];
    }
}