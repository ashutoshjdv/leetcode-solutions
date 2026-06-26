// Last updated: 6/26/2026, 8:54:28 AM
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i=0; i< grid.length; i++) {
            for(int j=0; j< grid[0].length; j++) {
                if( grid[i][j] == 1) {
                    
                    maxArea = Math.max(maxArea,dfs(i,j, grid));

                }
            }
        }

        return maxArea;
    }

    public int dfs(int r, int c, int[][] grid) {
        if(
            r < 0 ||
            r >= grid.length ||
            c < 0 ||
            c >= grid[0].length ||
            grid[r][c] == 0
        ) return 0;

        grid[r][c] = 0;

        int left = dfs(r,c-1, grid);
        int right = dfs(r,c+1, grid);
        int top = dfs(r-1,c, grid);
        int bottom = dfs(r+1,c, grid);

        return left + right + top + bottom + 1;
    }
}