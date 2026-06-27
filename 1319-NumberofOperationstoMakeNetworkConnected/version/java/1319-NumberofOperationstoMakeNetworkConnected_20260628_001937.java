// Last updated: 6/28/2026, 12:19:37 AM
1class Solution {
2    int components;
3    int duplicates = 0;
4    int[] parent;
5    int[] size;
6    public int makeConnected(int n, int[][] connections) {
7        this.components = n;
8        this.parent = new int[n];
9        this.size = new int[n];
10
11        for(int i=0; i<n; i++) {
12            parent[i] = i;
13            size[i] =1;
14        }
15
16        for(int[] connection : connections) {
17            union(connection[0], connection[1]);
18        }
19
20        if(duplicates >= components - 1) return (components -1);
21
22        return -1;
23
24    }
25
26    int find(int n) {
27        if(parent[n] == n) return n;
28
29        return parent[n] = find(parent[n]);
30    }
31
32    void union(int u, int v) {
33
34        int rootA = find(u);
35        int rootB = find(v);
36
37        if(rootA == rootB) {
38            duplicates++;
39            return;
40        }
41
42        if(size[rootA] > size[rootB]) {
43            parent[rootB] = rootA;
44            size[rootA] += size[rootB];
45        } else {
46            parent[rootA] = rootB;
47            size[rootB] += size[rootA];
48        }
49
50        components--;
51    }
52}