// Last updated: 6/28/2026, 12:55:26 AM
1class Solution {
2    int[] size;
3    int[] parent;
4    public boolean equationsPossible(String[] equations) {
5        
6
7        this.parent = new int[26];
8        this.size = new int[26];
9
10        for(int i =0; i< 26;i++) {
11            parent[i] = i;
12            size[i] = 1;
13        }
14
15        for(int i=0; i< equations.length; i++) {
16
17            if(equations[i].charAt(1) == '=') union(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a');
18
19        }
20
21        for(int i=0; i< equations.length; i++) {
22            if(equations[i].charAt(1) == '=') continue;
23
24            else{
25                if(checkUnion(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a')) return false;
26            }
27        }
28
29        return true;
30    }
31
32    int find(int n) {
33        if(parent[n] == n) return n;
34
35        return parent[n] = find(parent[n]);
36
37        
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
54
55    boolean checkUnion(int u, int v) {
56        int rootA = find(u);
57        int rootB = find(v);
58
59        if(rootA == rootB) return true;
60
61        return false;
62    }
63}