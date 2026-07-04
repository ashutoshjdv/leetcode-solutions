// Last updated: 7/4/2026, 10:12:25 AM
1class Solution {
2    public int deleteAndEarn(int[] nums) {
3        int maxNumber = 0;
4
5        for(int num : nums) {
6            maxNumber = Math.max(maxNumber, num);
7        }
8
9        int[] values = new int[maxNumber+1];
10
11        for(int num : nums) {
12            values[num] += num;
13        }
14
15        int[] dp = new int[maxNumber+3];
16
17        dp[maxNumber+2] = 0;
18        dp[maxNumber+1] = 0;
19
20        for(int i = maxNumber; i >= 0; i--) {
21            dp[i] = Math.max(values[i] + dp[i+2], dp[i+1]);
22        }
23
24        return dp[0];
25
26
27    }
28
29    // public int delete(int i, int[] nums) {
30
31    //     if(nums.length == 0) return 0;
32
33    //     List<Integer> values = new ArrayList<>();
34
35    //     for(int j : nums) {
36    //         if(j == i+1 || j == i-1) continue;
37
38    //         if(j == i && !flag) {
39    //             flag = true;
40    //             continue;
41    //         }
42    //         values.add(j);
43    //     }
44
45        
46    // }
47}