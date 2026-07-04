// Last updated: 7/5/2026, 2:35:51 AM
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;

        boolean[][] dp = new boolean[nums.length+1][sum/2+1];


        for(int i =0; i<=sum/2; i++) {
            dp[nums.length][i] = false;
        }

        for(int i=0; i<=nums.length; i++) {
            dp[i][0] = true;
        }

        for(int i=nums.length-1; i>=0;i--) {
            for(int j=sum/2; j>=0;j--) {

                boolean skip = dp[i+1][j];

                boolean take = false;

                if(nums[i] <= j) {
                    take = dp[i+1][j - nums[i]];
                } 

                dp[i][j] = take || skip;
            }
        }

        return dp[0][sum/2];
    }
}