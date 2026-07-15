// Last updated: 7/15/2026, 6:23:20 AM
1class Solution {
2    public int maxCoins(int[] nums) {
3        int n = nums.length;
4        int[][] dp = new int[n][n];
5        int coins = 0;
6
7        for(int i=n-1; i>=0; i--) {
8            for(int j=0; j<n;j++) {
9                if(i > j) {
10                    dp[i][j] = 0;
11                    continue;
12                }
13
14                int max = 0;
15                for(int k=j; k>=i;k--) {
16                    int left = k==i ? 0 : dp[i][k-1];
17                    int right = k==j ? 0 : dp[k+1][j];
18                    max = Math.max(max,
19                     nums[k] * (i-1 <0 ? 1 : nums[i-1]) * (j+1 >=n ? 1 : nums[j+1])
20                     + left + right);
21                }
22
23                dp[i][j] = max;
24            }
25        }
26
27        return dp[0][n-1];
28    }
29}