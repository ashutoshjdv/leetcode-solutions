// Last updated: 7/5/2026, 2:35:53 AM
class Solution {
    int[][] dp;
    int[] nums;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        this.nums = nums;

        this.dp = new int[n+1][n+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper();
    }

    public int helper() {

        for(int i=0; i<nums.length+1;i++) {
            dp[nums.length][i] = 0;
        }

        for(int i = nums.length -1; i>=0; i--) {
            for (int prevIndex = i - 1; prevIndex >= -1; prevIndex--) {
                int take =0;
                int col = prevIndex + 1;

                if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
                    take = 1 + dp[i + 1][i + 1];
                }

                int skip = dp[i + 1][col];

                dp[i][prevIndex+1] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }
}