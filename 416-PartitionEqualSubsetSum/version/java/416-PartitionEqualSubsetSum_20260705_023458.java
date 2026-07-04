// Last updated: 7/5/2026, 2:34:58 AM
1class Solution {
2    public boolean canPartition(int[] nums) {
3        int sum = 0;
4
5        for(int num : nums) {
6            sum += num;
7        }
8        if(sum % 2 != 0) return false;
9
10        boolean[][] dp = new boolean[nums.length+1][sum/2+1];
11
12
13        for(int i =0; i<=sum/2; i++) {
14            dp[nums.length][i] = false;
15        }
16
17        for(int i=0; i<=nums.length; i++) {
18            dp[i][0] = true;
19        }
20
21        for(int i=nums.length-1; i>=0;i--) {
22            for(int j=sum/2; j>=0;j--) {
23
24                boolean skip = dp[i+1][j];
25
26                boolean take = false;
27
28                if(nums[i] <= j) {
29                    take = dp[i+1][j - nums[i]];
30                } 
31
32                dp[i][j] = take || skip;
33            }
34        }
35
36        return dp[0][sum/2];
37    }
38}