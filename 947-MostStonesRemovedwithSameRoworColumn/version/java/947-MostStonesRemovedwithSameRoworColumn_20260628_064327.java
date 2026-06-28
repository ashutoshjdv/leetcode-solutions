// Last updated: 6/28/2026, 6:43:27 AM
1class Solution {
2
3    int[] parent;
4    int[] size;
5    int components;
6    public int removeStones(int[][] stones) {
7        
8        this.parent = new int[stones.length];
9        this.size = new int[stones.length];
10        this.components = stones.length;
11
12        for(int i=0; i<stones.length; i++) {
13            parent[i] = i;
14            size[i] = 1;
15        }
16
17        for(int i=0; i<stones.length; i++) {
18            for(int j=i; j<stones.length; j++) {
19                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
20                    union(i,j);
21                }
22            }
23        }
24
25        return stones.length - components;
26    }
27
28    int find(int n) {
29        if(parent[n] == n) return n;
30
31        return parent[n] = find(parent[n]);
32    }
33
34    void union(int u,int v) {
35        int ru = find(u);
36        int rv = find(v);
37
38        if(ru == rv) return;
39
40        if(size[ru] > size[rv]) {
41            parent[rv] = ru;
42            size[ru] += size[rv];
43        } else {
44            parent[ru] = rv;
45            size[rv] += size[ru];
46        }
47        components--;
48    }
49}