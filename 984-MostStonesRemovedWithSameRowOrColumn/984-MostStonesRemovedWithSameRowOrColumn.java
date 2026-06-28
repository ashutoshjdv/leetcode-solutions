// Last updated: 6/28/2026, 8:26:51 PM
class Solution {

    int[] parent;
    int[] size;
    int components;
    public int removeStones(int[][] stones) {
        
        this.parent = new int[stones.length];
        this.size = new int[stones.length];
        this.components = stones.length;

        for(int i=0; i<stones.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<stones.length; i++) {
            for(int j=i; j<stones.length; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i,j);
                }
            }
        }

        return stones.length - components;
    }

    int find(int n) {
        if(parent[n] == n) return n;

        return parent[n] = find(parent[n]);
    }

    void union(int u,int v) {
        int ru = find(u);
        int rv = find(v);

        if(ru == rv) return;

        if(size[ru] > size[rv]) {
            parent[rv] = ru;
            size[ru] += size[rv];
        } else {
            parent[ru] = rv;
            size[rv] += size[ru];
        }
        components--;
    }
}