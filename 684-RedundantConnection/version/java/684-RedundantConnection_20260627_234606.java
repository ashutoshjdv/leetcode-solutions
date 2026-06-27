// Last updated: 6/27/2026, 11:46:06 PM
1class Solution {
2
3    int[] parent;
4    public int[] findRedundantConnection(int[][] edges) {
5
6        int[] answer = {-1,-1};
7        
8        this.parent = new int[edges.length];
9
10        for(int i=0; i< edges.length; i++) {
11            parent[i] = i;
12        }
13
14        for(int i=0; i<edges.length;i++) {
15            if(union(edges[i][0] - 1,edges[i][1] - 1)) {
16                answer[0] = edges[i][0];
17                answer[1] = edges[i][1];
18            }
19        }
20
21        return answer;
22        
23    }
24
25    int find(int n) {
26        if(parent[n] == n) return n;
27
28        return parent[n] = find(parent[n]);
29    }
30
31    boolean union(int u, int v) {
32        int rootA = find(u);
33        int rootB = find(v);
34        if(rootA == rootB) return true;
35
36        parent[rootB] = rootA;
37
38        return false;
39    }
40}