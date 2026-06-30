// Last updated: 6/30/2026, 7:14:40 PM
class Solution {

    int shortestPath = Integer.MAX_VALUE;
    boolean flag = false;
    boolean[][] visited;

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1) return -1;

        if(grid.length == 1) return 1;

        this.visited = new boolean[grid.length][grid.length];
        
        Deque<int[]> queue = new ArrayDeque<>();

        int distance = 1;


        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size-- >0) {

                int[] node = queue.poll();
            
                if(checker(node[0]-1,node[1], grid) && !visited[node[0]-1][node[1]])
                 helper(node[0]-1,node[1], grid, queue); //left
                if(checker(node[0]-1,node[1]-1, grid) && !visited[node[0]-1][node[1]-1])
                helper(node[0]-1,node[1]-1, grid, queue); // left-top
                if(checker(node[0],node[1]-1, grid) && !visited[node[0]][node[1]-1])
                helper(node[0],node[1]-1, grid, queue); //top
                if(checker(node[0]+1,node[1]-1, grid) && !visited[node[0]+1][node[1]-1])
                helper(node[0]+1,node[1]-1, grid, queue); //right-top
                if(checker(node[0]+1,node[1], grid) && !visited[node[0]+1][node[1]])
                helper(node[0]+1,node[1], grid, queue); //right
                if(checker(node[0]+1,node[1]+1, grid) && !visited[node[0]+1][node[1]+1])
                helper(node[0]+1,node[1]+1, grid, queue); //right-bottom
                if(checker(node[0],node[1]+1, grid) && !visited[node[0]][node[1]+1])
                helper(node[0],node[1]+1, grid, queue); //bottom
                if(checker(node[0]-1,node[1]+1, grid) && !visited[node[0]-1][node[1]+1])
                helper(node[0]-1,node[1]+1, grid, queue); //left-bottom

                if(flag) return distance+1;
            }

            distance++;
        }

        return -1;
    }

    void helper(int i, int j, int[][] grid, Deque<int[]> queue) {

        visited[i][j] = true;

        if(i == grid.length -1 && j == grid.length -1) {
            flag = true;
            return;
        }

        queue.offer(new int[]{i,j});

    }

    boolean checker(int i, int j, int[][] grid) {
        

        if(i < 0 || i >= grid.length || j< 0 || j>= grid.length) return false;

        if(grid[i][j] == 1) {
            visited[i][j] = true;
            return false;
        }

        return true;
    }
}