// Last updated: 6/28/2026, 1:00:33 AM
class Solution {
    int[] size;
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        

        this.parent = new int[26];
        this.size = new int[26];

        for(int i =0; i< 26;i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i< equations.length; i++) {

            if(equations[i].charAt(1) == '=') union(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a');

        }

        for(int i=0; i< equations.length; i++) {
            if(equations[i].charAt(1) == '=') continue;

            else{
                if(checkUnion(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a')) return false;
            }
        }

        return true;
    }

    int find(int n) {
        if(parent[n] == n) return n;

        return parent[n] = find(parent[n]);

        
    }

    void union(int u, int v) {
        int rootA = find(u);
        int rootB = find(v);

        if(rootA == rootB) return;

        if(size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }

    boolean checkUnion(int u, int v) {
        int rootA = find(u);
        int rootB = find(v);

        if(rootA == rootB) return true;

        return false;
    }
}