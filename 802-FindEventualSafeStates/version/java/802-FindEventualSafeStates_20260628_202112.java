// Last updated: 6/28/2026, 8:21:12 PM
1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3
4        List<List<Integer>> rg = new ArrayList<>();
5
6        for(int i=0; i< graph.length; i++) {
7            rg.add(new ArrayList<>());
8        }
9
10        for(int i= 0; i< graph.length; i++) {
11            for(int j=0; j< graph[i].length; j++) {
12                rg.get(graph[i][j]).add(i);
13            }
14        }
15        
16        Deque<Integer> queue = new ArrayDeque<>();
17
18        int[] indegree = new int[rg.size()];
19
20        List<Integer> list = new ArrayList<>();
21 
22        for(int i=0; i< rg.size(); i++) {
23            for(int node : rg.get(i)) {
24                indegree[node]++;
25            }
26        }
27
28        for(int i=0; i< indegree.length; i++) {
29            if(indegree[i] == 0) queue.offer(i);
30        }
31
32        while(!queue.isEmpty()) {
33
34            int node = queue.poll();
35
36            for(int neighbor : rg.get(node) ) {
37                indegree[neighbor]--;
38
39                if(indegree[neighbor] == 0) queue.offer(neighbor);
40            }
41            list.add(node);
42
43
44        }
45        
46        Collections.sort(list);
47
48        return list;
49    }
50}