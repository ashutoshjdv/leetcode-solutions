// Last updated: 6/28/2026, 8:26:56 PM
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> rg = new ArrayList<>();

        for(int i=0; i< graph.length; i++) {
            rg.add(new ArrayList<>());
        }

        for(int i= 0; i< graph.length; i++) {
            for(int j=0; j< graph[i].length; j++) {
                rg.get(graph[i][j]).add(i);
            }
        }
        
        Deque<Integer> queue = new ArrayDeque<>();

        int[] indegree = new int[rg.size()];

        List<Integer> list = new ArrayList<>();
 
        for(int i=0; i< rg.size(); i++) {
            for(int node : rg.get(i)) {
                indegree[node]++;
            }
        }

        for(int i=0; i< indegree.length; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {

            int node = queue.poll();

            for(int neighbor : rg.get(node) ) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) queue.offer(neighbor);
            }
            list.add(node);


        }
        
        Collections.sort(list);

        return list;
    }
}