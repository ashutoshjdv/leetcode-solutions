// Last updated: 7/15/2026, 2:41:35 AM
1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3        int n1 = s1.length();
4        int n2 = s2.length();
5
6        int m = s3.length();
7
8        if(n1 + n2 != m) return false;
9
10        boolean[][] dp = new boolean[n1+1][n2+1];
11
12        dp[n1][n2] = true;
13
14        for(int i=n1-1; i>=0; i--) {
15            dp[i][n2] = (s1.charAt(i) == s3.charAt(i+n2)) && dp[i+1][n2];
16        }
17
18        for(int j=n2-1; j>=0; j--) {
19            dp[n1][j] = (s2.charAt(j) == s3.charAt(j+n1)) && dp[n1][j+1];
20        }
21
22        for(int i=n1-1; i>=0; i--) {
23            for(int j=n2-1; j>=0; j--) {
24                if(s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)) {
25                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
26                } else if(s1.charAt(i) == s3.charAt(i+j)) {
27                    dp[i][j] = dp[i+1][j];
28                } else if(s2.charAt(j) == s3.charAt(i+j)) {
29                    dp[i][j] = dp[i][j+1];
30                }
31            }
32        }
33
34        return dp[0][0];
35    } 
36}