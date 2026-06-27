// Last updated: 6/27/2026, 11:16:30 PM
1class Solution {
2
3    int[] parent;
4    int[] size;
5    public int findCircleNum(int[][] isConnected) {
6        this.parent = new int[isConnected.length];
7        this.size = new int[isConnected.length];
8
9        for(int i=0; i< isConnected.length; i++) {
10            parent[i] = i;
11            size[i] = 1;
12        }
13
14        for(int i=0; i< isConnected.length; i++) {
15            for(int j=0; j< isConnected.length; j++) {
16                if(i == j) continue;
17
18                if(isConnected[i][j] == 1) {
19                    union(i,j);
20                }
21            }
22        }
23
24        Set<Integer> set = new HashSet<>();
25
26        for(int i=0; i< parent.length; i++) {
27            if(!set.contains(find(i))) set.add(find(i));
28        }
29
30        return set.size();
31
32    }
33
34    int find(int n) {
35        if(parent[n] == n) return n;
36
37        return parent[n] = find(parent[n]);
38    }
39
40    void union(int u, int v) {
41        int rootA = find(u);
42        int rootB = find(v);
43
44        if(rootA == rootB) return;
45
46        if(size[rootA] > size[rootB]) {
47            parent[rootB] = rootA;
48            size[rootA] += size[rootB];
49        } else {
50            parent[rootA] = rootB;
51            size[rootB] += size[rootA];
52        }
53    }
54}