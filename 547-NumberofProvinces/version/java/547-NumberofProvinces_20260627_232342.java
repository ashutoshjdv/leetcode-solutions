// Last updated: 6/27/2026, 11:23:42 PM
1class Solution {
2
3    int[] parent;
4    int[] size;
5    int components;
6    public int findCircleNum(int[][] isConnected) {
7        this.parent = new int[isConnected.length];
8        this.size = new int[isConnected.length];
9
10        for(int i=0; i< isConnected.length; i++) {
11            parent[i] = i;
12            size[i] = 1;
13        }
14
15        this.components = isConnected.length;
16
17        for(int i=0; i< isConnected.length; i++) {
18            for(int j=i+1; j< isConnected.length; j++) {
19                if(i == j) continue;
20
21                if(isConnected[i][j] == 1) {
22                    union(i,j);
23                }
24            }
25        }
26
27        // Set<Integer> set = new HashSet<>();
28
29        // for(int i=0; i< parent.length; i++) {
30        //     if(!set.contains(find(i))) set.add(find(i));
31        // }
32
33        // return set.size();
34
35        return components;
36
37    }
38
39    int find(int n) {
40        if(parent[n] == n) return n;
41
42        return parent[n] = find(parent[n]);
43    }
44
45    void union(int u, int v) {
46        int rootA = find(u);
47        int rootB = find(v);
48
49        if(rootA == rootB) return;
50
51        if(size[rootA] > size[rootB]) {
52            parent[rootB] = rootA;
53            size[rootA] += size[rootB];
54        } else {
55            parent[rootA] = rootB;
56            size[rootB] += size[rootA];
57        }
58        components--;
59    }
60}