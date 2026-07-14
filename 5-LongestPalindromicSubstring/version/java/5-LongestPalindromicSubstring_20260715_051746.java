// Last updated: 7/15/2026, 5:17:46 AM
1class Solution {
2    public String longestPalindrome(String s) {
3        int n = s.length();
4
5        boolean[][] dp = new boolean[n][n];
6
7        int start = 0;
8        int maxLength = 1;
9
10        for(int i=n-1; i>=0; i--) {
11            for(int j=0; j<n; j++) {
12                if(i > j) {
13                    dp[i][j] = false;
14                    continue;
15                } else if(i == j) {
16                    dp[i][j] = true;
17                    continue;
18                }
19
20                if(s.charAt(i) == s.charAt(j)) {
21                    if (j - i <= 2) {
22                        dp[i][j] = true;
23                    } else {
24                        dp[i][j] = dp[i+1][j-1];
25                    }
26                } 
27
28                if(dp[i][j] && (j - i + 1 ) > maxLength ) {
29                        start = i;
30                        maxLength = j-i+1;
31                }
32
33            }
34        }
35
36        return s.substring(start, start+maxLength);
37    }
38}