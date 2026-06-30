// Last updated: 7/1/2026, 2:52:07 AM
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] state = new int[n][k+2];

        List<List<int[]>> fList = new ArrayList<>();

        for(int i=0;i<n;i++) {
            fList.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
            fList.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        for(int i=0;i<n;i++){
             Arrays.fill(state[i], Integer.MAX_VALUE);
        }
        state[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[2]-b[2]);

        pq.offer(new int[]{src,0,0});

        while(!pq.isEmpty()) {

            int[] poppedNode = pq.poll();

            int node = poppedNode[0];

            int edgesUsed = poppedNode[1];

            int cost = poppedNode[2];

            if(node == dst) return cost;

            if(cost > state[node][edgesUsed]) continue;

           for(int[] flight : fList.get(node)) {

                if(edgesUsed+1 <= k+1 && (cost + flight[1] < state[flight[0]][edgesUsed+1])) {

                    state[flight[0]][edgesUsed+1] = cost + flight[1];

                    pq.offer(new int[]{flight[0],edgesUsed+1, state[flight[0]][edgesUsed+1]});
                }
           } 

        }

        return -1;
    }
}