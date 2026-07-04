// Last updated: 7/4/2026, 11:23:21 AM
1class Solution {
2    public int numDecodings(String s) {
3
4        int n = s.length();
5
6        int[] dp = new int[n + 1];
7
8        // Base case: empty string has one valid decoding
9        dp[n] = 1;
10
11        for (int i = n - 1; i >= 0; i--) {
12
13            // A decoding cannot start with '0'
14            if (s.charAt(i) == '0') {
15                dp[i] = 0;
16                continue;
17            }
18
19            // Take one digit
20            dp[i] = dp[i + 1];
21
22            // Take two digits if valid
23            if (i + 1 < n) {
24
25                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
26
27                if (num >= 10 && num <= 26) {
28                    dp[i] += dp[i + 2];
29                }
30            }
31        }
32
33        return dp[0];
34    }
35}