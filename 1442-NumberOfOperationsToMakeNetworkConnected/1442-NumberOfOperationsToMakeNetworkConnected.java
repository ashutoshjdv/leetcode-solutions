// Last updated: 6/28/2026, 12:25:15 AM
class Solution {
    int components;
    int duplicates = 0;
    int[] parent;
    int[] size;
    public int makeConnected(int n, int[][] connections) {
        this.components = n;
        this.parent = new int[n];
        this.size = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] =1;
        }

        for(int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        if(duplicates >= components - 1) return (components -1);

        return -1;

    }

    int find(int n) {
        if(parent[n] == n) return n;

        return parent[n] = find(parent[n]);
    }

    void union(int u, int v) {

        int rootA = find(u);
        int rootB = find(v);

        if(rootA == rootB) {
            duplicates++;
            return;
        }

        if(size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }

        components--;
    }
}