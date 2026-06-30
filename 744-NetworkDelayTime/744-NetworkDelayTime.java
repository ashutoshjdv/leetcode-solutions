// Last updated: 6/30/2026, 9:59:43 PM
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> timeList = new ArrayList<>();

        for(int i=0;i<=n;i++) {
            timeList.add(new ArrayList<>());
        }

        for(int[] time : times) {
            timeList.get(time[0]).add( new int[]{time[1], time[2]});
        }

        int[] distance = new int[n+1];

        for(int i=1; i<=n; i++) {
           if(i == k) distance[i] = 0;
           else distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1]);

        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()) {

            int[] node = pq.poll();

            if(node[1] > distance[node[0]]) continue;

            for(int[] neighbor : timeList.get(node[0])) {
                
                if(distance[node[0]] + neighbor[1] < distance[neighbor[0]]) {

                    distance[neighbor[0]] = distance[node[0]] + neighbor[1];

                    pq.offer(new int[]{neighbor[0], distance[neighbor[0]]});
                }
            }
        }

        int max_time = 0;

        for(int i =1; i<distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) return -1;
            max_time = Math.max(max_time, distance[i]);
        }

        return max_time;
    }
}