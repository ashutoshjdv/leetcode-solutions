// Last updated: 7/3/2026, 1:22:25 AM
class Solution {

    public int minCostConnectPoints(int[][] points) {
        boolean[] visited = new boolean[points.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1]-b[1]);

        pq.offer(new int[]{0,0});

        int total_cost =0;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();

            int i = node[0];

            int cost = node[1];

            if(visited[i]) continue;

            visited[i] = true;

            total_cost += cost;

            for(int j=0; j< points.length; j++) {
                if(visited[j]) continue;

                int man_cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                pq.offer(new int[]{j, man_cost});
            } 
        }

        return total_cost;
    }
    // public int minCostConnectPoints(int[][] points) {
    //     Set<Integer> visited = new HashSet<>();

    //     Map<Integer, String> adjList = new HashMap<>();

    //     for(int i=0; i< points.length; i++) {
    //         adjList.put(i, ""+points[i][0]+points[i][1]);
    //     }

    //     PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1]-b[1]);

    //     int total_cost = 0;

    //     pq.offer(new int[]{0, 0});

    //     while(!pq.isEmpty()) {

    //         int[] element = pq.poll();

    //         String node = adjList.get(element[0]);

    //         int cost = element[1];

    //         if(visited.contains(element[0])) continue;

    //         visited.add(element[0]);

    //         total_cost += cost;

    //         for(int i : adjList.keySet() ) {
    //             String neighbor = adjList.get(i);

    //             if(neighbor.equals(node)) continue;

    //             int neighborX = Character.getNumericValue(neighbor.charAt(0));
    //             int neighborY = Character.getNumericValue(neighbor.charAt(1));
    //             int nodeX = Character.getNumericValue(node.charAt(0));
    //             int nodeY = Character.getNumericValue(node.charAt(1));

    //             int man_cost = Math.abs(nodeX-neighborX) + Math.abs(nodeY-neighborY);

    //             pq.offer(new int[]{i, man_cost});
    //         }
    //     }

    //     return total_cost;
    // }
}