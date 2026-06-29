// Last updated: 6/29/2026, 5:26:02 PM
1class Solution {
2    public boolean possibleBipartition(int n, int[][] dislikes) {
3        
4        Deque<Integer> queue = new ArrayDeque<>();
5
6        Map<Integer, List<Integer>> map = new HashMap<>();
7
8        for(int i = 0; i< dislikes.length; i++) {
9            map.computeIfAbsent(dislikes[i][0], k -> new ArrayList<>()).add(dislikes[i][1]);
10
11            map.computeIfAbsent(dislikes[i][1], k -> new ArrayList<>()).add(dislikes[i][0]);
12        }
13
14        Map<Integer, Integer> mapLikes = new HashMap<>();
15
16
17        for(int key : map.keySet()) {
18            mapLikes.put(key, -1);
19        }
20
21        for(int key : map.keySet()) {
22
23            if(mapLikes.get(key) != -1) continue;
24
25            queue.offer(key);
26            mapLikes.put(key, 0);
27
28            while(!queue.isEmpty()) {
29
30                int node = queue.poll();
31
32                for(int neighbor : map.get(node)) {
33
34                    if(mapLikes.get(node) == mapLikes.get(neighbor)) return false;
35
36                    if(mapLikes.get(neighbor) == -1) {
37                        queue.offer(neighbor);
38                        mapLikes.put(neighbor, mapLikes.get(node) == 0 ? 1 : 0);
39                    }
40                }
41
42            }
43        }
44
45        return true;
46
47    }
48}