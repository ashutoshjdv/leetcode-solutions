// Last updated: 6/27/2026, 11:55:06 PM
class Solution {

    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {

        int[] answer = {-1,-1};
        
        this.parent = new int[edges.length];

        for(int i=0; i< edges.length; i++) {
            parent[i] = i;
        }

        for(int i=0; i<edges.length;i++) {
            if(union(edges[i][0] - 1,edges[i][1] - 1)) {
                answer[0] = edges[i][0];
                answer[1] = edges[i][1];
            }
        }

        return answer;
        
    }

    int find(int n) {
        if(parent[n] == n) return n;

        return parent[n] = find(parent[n]);
    }

    boolean union(int u, int v) {
        int rootA = find(u);
        int rootB = find(v);
        if(rootA == rootB) return true;

        parent[rootB] = rootA;

        return false;
    }
}