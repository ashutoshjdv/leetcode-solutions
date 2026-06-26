// Last updated: 6/26/2026, 8:54:19 AM
class Solution {

    int freshOranges = 0;

    public int orangesRotting(int[][] grid) {
        //if rotten then we go bfs from that node
        //rot every node if it has orange when traversing through bfs
        // if come across fresh orange when traversing store it in set.
        // if there is any element after traversing in set then return -1
        //every level of traverse in bfs adds minute.
        int rottenMinutes = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        for(int i=0; i< grid.length; i++) {
            for(int j=0; j< grid[0].length;j++) {
                if(grid[i][j] == 1) freshOranges++;

                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }

        while(!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();

            rottenMinutes++;

            for(int i =0; i< size; i++) {
                int[] index = queue.poll();
                
                helper(index[0]+1,index[1], queue, grid);
                helper(index[0]-1,index[1], queue, grid);
                helper(index[0],index[1]+1, queue, grid);
                helper(index[0],index[1]-1, queue, grid);

            }
        }

        if(freshOranges > 0) return -1;

        return rottenMinutes;
    }


    public void helper(int i, int j, Deque<int[]> queue, int[][] grid) {

        if(
            i<0 ||
            j<0 ||
            i>=grid.length ||
            j>=grid[0].length ||
            grid[i][j] != 1 
        ) return;

        grid[i][j] = 2;

        freshOranges--;

        queue.offer(new int[]{i,j});

    }
}