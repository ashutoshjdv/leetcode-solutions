// Last updated: 7/4/2026, 4:59:03 AM
1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        if(n == 0) return 0;
5        if(n == 1) return nums[0];
6        return Math.max(helper(Arrays.copyOfRange(nums,0,n-1)), helper(Arrays.copyOfRange(nums,1,n)));
7    }
8
9    public int helper(int[] nums) {
10        int[] dp = new int[nums.length + 2];
11
12        dp[nums.length] = 0;
13
14        dp[nums.length +1] = 0;
15
16        for(int i=nums.length -1; i>=0;i-- ) {
17            dp[i] = Math.max(dp[i+2] + nums[i], dp[i+1]);
18        }
19
20        return dp[0];
21    }
22}