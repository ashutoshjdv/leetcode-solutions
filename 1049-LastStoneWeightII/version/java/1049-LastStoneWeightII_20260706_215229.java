// Last updated: 7/6/2026, 9:52:29 PM
1class Solution {
2    public int lastStoneWeightII(int[] stones) {
3        
4        int n = stones.length;
5
6        int sum = 0;
7
8        for(int stone : stones) {
9            sum += stone;
10        }
11
12        int target = sum/2;
13
14
15        int[][] dp = new int[n+1][target + 1];
16
17        for(int i=n-1; i>=0 ; i--) {
18            for(int j=target ; j>=0; j--) {
19
20                int skip = dp[i+1][j];
21
22                int take =0;
23
24                if(stones[i] <= j) {
25                    take = stones[i] + dp[i+1][j-stones[i]];
26                }
27
28                dp[i][j] = Math.max(skip, take);
29            }
30        }
31
32        return sum - 2 * dp[0][target];
33
34    }
35}