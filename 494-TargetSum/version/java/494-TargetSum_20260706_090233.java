// Last updated: 7/6/2026, 9:02:33 AM
1class Solution {
2    public int findTargetSumWays(int[] nums, int target) {
3        int sum = 0;
4
5        for(int num : nums) {
6            sum+=num;
7        }
8
9        if(Math.abs(target) > sum) return 0;
10
11        if((sum+target)%2 !=0) return 0;
12
13        int posNumbers = (sum + target) /2;
14
15        int[][] dp = new int[nums.length + 1][posNumbers + 1];
16
17        dp[nums.length][0] = 1;
18
19        for(int i=nums.length-1; i>=0; i--) {
20            for(int j=posNumbers; j>=0; j--) {
21
22                int skip = dp[i+1][j];
23
24                int take =0;
25                if(nums[i] <= j) {
26                    take = dp[i+1][j - nums[i]];
27                }
28
29                dp[i][j] = skip + take;
30            }
31        }
32
33        return dp[0][posNumbers];
34    }
35}