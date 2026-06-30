// Last updated: 7/1/2026, 1:16:49 AM
1class Solution {
2    public int minimumEffortPath(int[][] heights) {
3
4        int[][] maxDistance = new int[heights.length][heights[0].length];
5
6        for(int i=0; i<heights.length;i++) {
7            for(int j=0; j< heights[0].length;j++) {
8                if(i == 0 && j== 0) maxDistance[i][j] = 0;
9                else maxDistance[i][j] = Integer.MAX_VALUE;
10            }
11        }
12
13        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->a[2]-b[2]);
14
15        pq.offer(new int[]{0,0,0});
16
17        int[][] directions = {
18            {-1,0},
19            {1,0},
20            {0,-1},
21            {0,1}
22        };
23
24        while(!pq.isEmpty()) {
25
26            int[] node = pq.poll();
27            int nodeX = node[0];
28            int nodeY = node[1];
29            int distance = node[2];
30
31            if(distance > maxDistance[nodeX][nodeY]) continue;
32
33            for(int[] dir : directions) {
34                int nr = nodeX + dir[0];
35                int nc = nodeY + dir[1];
36
37                if(nr < 0 || nr >= heights.length || nc <0 || nc >= heights[0].length) continue;
38
39                int diff = Math.abs(heights[nodeX][nodeY] - heights[nr][nc]);
40
41                int value = Math.max(diff, distance);
42
43                if( value < maxDistance[nr][nc]) {
44                    maxDistance[nr][nc] = value;
45                    pq.offer(new int[] {nr,nc, maxDistance[nr][nc]});
46                }
47
48            }
49        }
50
51        return maxDistance[heights.length -1][heights[0].length -1];
52    }
53}