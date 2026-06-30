// Last updated: 6/30/2026, 9:51:42 PM
1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        List<List<int[]>> timeList = new ArrayList<>();
4
5        for(int i=0;i<=n;i++) {
6            timeList.add(new ArrayList<>());
7        }
8
9        for(int[] time : times) {
10            timeList.get(time[0]).add( new int[]{time[1], time[2]});
11        }
12
13        int[] distance = new int[n+1];
14
15        for(int i=1; i<=n; i++) {
16           if(i == k) distance[i] = 0;
17           else distance[i] = Integer.MAX_VALUE;
18        }
19
20        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1]);
21
22        pq.offer(new int[]{k,0});
23
24        while(!pq.isEmpty()) {
25
26            int[] node = pq.poll();
27
28            if(node[1] > distance[node[0]]) continue;
29
30            for(int[] neighbor : timeList.get(node[0])) {
31                
32                if(distance[node[0]] + neighbor[1] < distance[neighbor[0]]) {
33
34                    distance[neighbor[0]] = distance[node[0]] + neighbor[1];
35
36                    pq.offer(new int[]{neighbor[0], distance[neighbor[0]]});
37                }
38            }
39        }
40
41        int max_time = 0;
42
43        for(int i =1; i<distance.length; i++) {
44            if(distance[i] == Integer.MAX_VALUE) return -1;
45            max_time = Math.max(max_time, distance[i]);
46        }
47
48        return max_time;
49    }
50}