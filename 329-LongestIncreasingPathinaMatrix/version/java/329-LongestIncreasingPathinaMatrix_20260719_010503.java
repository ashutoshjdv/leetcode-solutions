// Last updated: 7/19/2026, 1:05:03 AM
1class Solution {
2    int m;
3    int n;
4    int[][] dp;
5    int longestPath = 0;
6
7    public int longestIncreasingPath(int[][] matrix) {
8
9        this.m = matrix.length;
10        this.n = matrix[0].length;
11        
12        this.dp = new int[m][n];
13
14        for(int[] row : dp) {
15            Arrays.fill(row, -1);
16        }
17
18        for(int i = 0; i < m; i++) {
19            for(int j = 0; j < n; j++) {
20                longestPath = Math.max(longestPath, dfs(i,j, matrix));
21            }
22        }
23
24        return longestPath;
25    }
26
27    public int dfs(int i, int j, int[][] matrix) {
28        if(dp[i][j] != -1) return dp[i][j];
29
30        int left = (j > 0 && matrix[i][j] > matrix[i][j-1]) ? dfs(i, j-1, matrix) : 0;
31        int right = (j < n-1 && matrix[i][j] > matrix[i][j+1]) ? dfs(i, j+1, matrix) : 0;
32        int top = (i > 0 && matrix[i][j] > matrix[i-1][j]) ? dfs(i-1, j, matrix) : 0;
33        int bottom = (i < m-1 && matrix[i][j] > matrix[i+1][j]) ? dfs(i+1,j, matrix) : 0;
34
35        dp[i][j] = 1 + Math.max(left, Math.max(right, Math.max(top, bottom)));
36
37        return dp[i][j];
38    }
39}