// Last updated: 7/6/2026, 6:55:04 PM
1class Solution {
2
3    int[] coins;
4
5    public int coinChange(int[] coins, int amount) {
6
7        if(amount == 0) return 0;
8
9        int[][] dp = new int[coins.length +1][amount+1];
10
11        for(int j=1; j <= amount; j++) {
12            dp[coins.length][j] = Integer.MAX_VALUE;
13        }
14
15        for(int i=coins.length-1; i>=0; i--) {
16            for(int j=0; j<=amount; j++) {
17
18                int skip = dp[i+1][j];
19
20                int take = Integer.MAX_VALUE;
21
22                if(coins[i] <= j && dp[i][j-coins[i]] != Integer.MAX_VALUE) {
23                    take = 1 + dp[i][j-coins[i]];
24                }
25
26                dp[i][j] = Math.min(skip, take);
27            }
28        }
29
30        return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
31        
32    }
33
34    public int helper(int remainingAmount) {
35
36        if(remainingAmount == 0) return 0;
37
38        int take = Integer.MAX_VALUE;
39
40        for(int coin : coins) {
41
42            if(coin <= remainingAmount) {
43               int res = helper(remainingAmount-coin);
44               if(res != Integer.MAX_VALUE)
45               take = Math.min(take, 1 + helper(remainingAmount-coin));
46            }
47        }
48
49        return take;
50    }
51
52    public int helperRec(int i, int remainingAmount) {
53
54        if(remainingAmount == 0) return 0;
55
56        if(i >= coins.length) return Integer.MAX_VALUE;
57
58
59        int skip = helperRec(i+1, remainingAmount);
60
61        int take = Integer.MAX_VALUE;
62
63        if(coins[i] <= remainingAmount) {
64            int res = helperRec(i,remainingAmount-coins[i]);
65            if(res != Integer.MAX_VALUE)
66            take = 1 + res;
67        }
68
69        return Math.min(skip, take);
70    }
71
72    
73
74}