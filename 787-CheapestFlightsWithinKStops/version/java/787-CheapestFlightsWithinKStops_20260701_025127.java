// Last updated: 7/1/2026, 2:51:27 AM
1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        
4        int[][] state = new int[n][k+2];
5
6        List<List<int[]>> fList = new ArrayList<>();
7
8        for(int i=0;i<n;i++) {
9            fList.add(new ArrayList<>());
10        }
11
12        for(int[] flight : flights) {
13            fList.get(flight[0]).add(new int[]{flight[1], flight[2]});
14        }
15
16        for(int i=0;i<n;i++){
17             Arrays.fill(state[i], Integer.MAX_VALUE);
18        }
19        state[src][0] = 0;
20
21        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[2]-b[2]);
22
23        pq.offer(new int[]{src,0,0});
24
25        while(!pq.isEmpty()) {
26
27            int[] poppedNode = pq.poll();
28
29            int node = poppedNode[0];
30
31            int edgesUsed = poppedNode[1];
32
33            int cost = poppedNode[2];
34
35            if(node == dst) return cost;
36
37            if(cost > state[node][edgesUsed]) continue;
38
39           for(int[] flight : fList.get(node)) {
40
41                if(edgesUsed+1 <= k+1 && (cost + flight[1] < state[flight[0]][edgesUsed+1])) {
42
43                    state[flight[0]][edgesUsed+1] = cost + flight[1];
44
45                    pq.offer(new int[]{flight[0],edgesUsed+1, state[flight[0]][edgesUsed+1]});
46                }
47           } 
48
49        }
50
51        return -1;
52    }
53}