// Last updated: 6/26/2026, 8:54:30 AM
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected.length == 0) return 0;

        int provinces = 0;

        boolean[] visited = new boolean[isConnected.length];

        for(int i=0; i< isConnected.length; i++){

            if(visited[i]) continue;
            provinces++;
            
            dfs(isConnected,visited, i);
        }

        return provinces;
    }

    public void dfs(int[][] isConnected,boolean[] visited, int node) {
        visited[node] = true;
        for(int i=0;i<isConnected[node].length;i++) {
            if(!visited[i] && isConnected[node][i] == 1){
                dfs(isConnected, visited, i);
            }
        }
    }
}