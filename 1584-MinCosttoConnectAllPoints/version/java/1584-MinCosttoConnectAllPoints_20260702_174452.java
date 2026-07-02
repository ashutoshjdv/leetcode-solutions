// Last updated: 7/2/2026, 5:44:52 PM
1class Solution {
2
3    public int minCostConnectPoints(int[][] points) {
4        boolean[] visited = new boolean[points.length];
5
6        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1]-b[1]);
7
8        pq.offer(new int[]{0,0});
9
10        int total_cost =0;
11
12        while(!pq.isEmpty()) {
13            int[] node = pq.poll();
14
15            int i = node[0];
16
17            int cost = node[1];
18
19            if(visited[i]) continue;
20
21            visited[i] = true;
22
23            total_cost += cost;
24
25            for(int j=0; j< points.length; j++) {
26                if(visited[j]) continue;
27
28                int man_cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
29
30                pq.offer(new int[]{j, man_cost});
31            } 
32        }
33
34        return total_cost;
35    }
36    // public int minCostConnectPoints(int[][] points) {
37    //     Set<Integer> visited = new HashSet<>();
38
39    //     Map<Integer, String> adjList = new HashMap<>();
40
41    //     for(int i=0; i< points.length; i++) {
42    //         adjList.put(i, ""+points[i][0]+points[i][1]);
43    //     }
44
45    //     PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1]-b[1]);
46
47    //     int total_cost = 0;
48
49    //     pq.offer(new int[]{0, 0});
50
51    //     while(!pq.isEmpty()) {
52
53    //         int[] element = pq.poll();
54
55    //         String node = adjList.get(element[0]);
56
57    //         int cost = element[1];
58
59    //         if(visited.contains(element[0])) continue;
60
61    //         visited.add(element[0]);
62
63    //         total_cost += cost;
64
65    //         for(int i : adjList.keySet() ) {
66    //             String neighbor = adjList.get(i);
67
68    //             if(neighbor.equals(node)) continue;
69
70    //             int neighborX = Character.getNumericValue(neighbor.charAt(0));
71    //             int neighborY = Character.getNumericValue(neighbor.charAt(1));
72    //             int nodeX = Character.getNumericValue(node.charAt(0));
73    //             int nodeY = Character.getNumericValue(node.charAt(1));
74
75    //             int man_cost = Math.abs(nodeX-neighborX) + Math.abs(nodeY-neighborY);
76
77    //             pq.offer(new int[]{i, man_cost});
78    //         }
79    //     }
80
81    //     return total_cost;
82    // }
83}