// Last updated: 7/6/2026, 6:55:54 PM
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for(int num : nums) {
            sum+=num;
        }

        if(Math.abs(target) > sum) return 0;

        if((sum+target)%2 !=0) return 0;

        int posNumbers = (sum + target) /2;

        int[][] dp = new int[nums.length + 1][posNumbers + 1];

        dp[nums.length][0] = 1;

        for(int i=nums.length-1; i>=0; i--) {
            for(int j=posNumbers; j>=0; j--) {

                int skip = dp[i+1][j];

                int take =0;
                if(nums[i] <= j) {
                    take = dp[i+1][j - nums[i]];
                }

                dp[i][j] = skip + take;
            }
        }

        return dp[0][posNumbers];
    }
}