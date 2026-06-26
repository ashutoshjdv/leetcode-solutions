// Last updated: 6/26/2026, 8:54:58 AM
class Solution {
    public int numIslands(char[][] grid) {

        int islands = 0;

        for(int i=0; i< grid.length; i++) {
            for(int j =0; j< grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }

        return islands;
    }

    public void dfs(int r, int c, char[][] grid) {
        if(r >= grid.length || 
            r < 0 ||
            c >= grid[0].length || 
            c < 0 ||
            grid[r][c] == '0'
            
          ) return;

        grid[r][c] = '0';

        dfs(r-1, c, grid);
        dfs(r+1, c, grid);
        dfs(r, c-1, grid);
        dfs(r, c+1, grid);
    }
}