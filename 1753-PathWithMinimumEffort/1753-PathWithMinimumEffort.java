// Last updated: 7/1/2026, 2:51:58 AM
class Solution {
    public int minimumEffortPath(int[][] heights) {

        int[][] maxDistance = new int[heights.length][heights[0].length];

        for(int i=0; i<heights.length;i++) {
            for(int j=0; j< heights[0].length;j++) {
                if(i == 0 && j== 0) maxDistance[i][j] = 0;
                else maxDistance[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->a[2]-b[2]);

        pq.offer(new int[]{0,0,0});

        int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!pq.isEmpty()) {

            int[] node = pq.poll();
            int nodeX = node[0];
            int nodeY = node[1];
            int distance = node[2];

            if(distance > maxDistance[nodeX][nodeY]) continue;

            for(int[] dir : directions) {
                int nr = nodeX + dir[0];
                int nc = nodeY + dir[1];

                if(nr < 0 || nr >= heights.length || nc <0 || nc >= heights[0].length) continue;

                int diff = Math.abs(heights[nodeX][nodeY] - heights[nr][nc]);

                int value = Math.max(diff, distance);

                if( value < maxDistance[nr][nc]) {
                    maxDistance[nr][nc] = value;
                    pq.offer(new int[] {nr,nc, maxDistance[nr][nc]});
                }

            }
        }

        return maxDistance[heights.length -1][heights[0].length -1];
    }
}