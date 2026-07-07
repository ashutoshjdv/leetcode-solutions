// Last updated: 7/7/2026, 5:43:36 PM
1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        List<List<Integer>> dp = new ArrayList<>();
4        int levels = triangle.size();
5        for(int i=0; i<levels; i++) {
6            dp.add(new ArrayList<>());
7            int levelSize = triangle.get(i).size();
8            for(int j=0; j<levelSize; j++) {
9                dp.get(i).add(0);
10            }
11        }
12
13        for(int i=levels-1; i>=0;i--) {
14            int levelSize = triangle.get(i).size();
15            for(int j=levelSize-1;j>=0; j--) {
16
17                if(i == levels-1) {
18                    dp.get(i).set(j,triangle.get(i).get(j));
19                    continue;
20                }
21
22                int left = Integer.MAX_VALUE;
23                int right = Integer.MAX_VALUE;
24                
25                if(i+1 <= levels-1) {
26                    left = dp.get(i+1).get(j);
27                    right = dp.get(i+1).get(j+1);
28                }
29
30                dp.get(i).set(j, triangle.get(i).get(j) + Math.min(left,right));
31            }
32        }
33
34        return dp.get(0).get(0);
35    }
36}