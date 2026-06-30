// Last updated: 6/30/2026, 7:14:49 PM
class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] visited = new int[graph.length];

        int[] color = new int[graph.length];

        Arrays.fill(color, -1);

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i=0; i< graph.length; i++) {

            if(visited[i] == 1) continue;

            queue.offer(i);

            color[i] = 0;

            while(!queue.isEmpty()) {

                int size = queue.size();

                int node = queue.poll();

                for(int neighbor : graph[node]) {
                    
                    if(color[neighbor] == color[node]) return false;

                    if(color[neighbor] == -1) {

                        queue.offer(neighbor);
                        color[neighbor] = color[node] == 0 ? 1 : 0;
                    }
                    
                }

                visited[node] = 1;
            }
        }

        return true;
    }
}