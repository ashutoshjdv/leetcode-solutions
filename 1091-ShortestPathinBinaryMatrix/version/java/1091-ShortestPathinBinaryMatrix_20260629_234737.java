// Last updated: 6/29/2026, 11:47:37 PM
1class Solution {
2
3    int shortestPath = Integer.MAX_VALUE;
4    boolean flag = false;
5    boolean[][] visited;
6
7    public int shortestPathBinaryMatrix(int[][] grid) {
8
9        if(grid[0][0] == 1) return -1;
10
11        if(grid.length == 1) return 1;
12
13        this.visited = new boolean[grid.length][grid.length];
14        
15        Deque<int[]> queue = new ArrayDeque<>();
16
17        int distance = 1;
18
19
20        queue.offer(new int[]{0,0});
21        visited[0][0] = true;
22
23        while(!queue.isEmpty()) {
24
25            int size = queue.size();
26
27            while(size-- >0) {
28
29                int[] node = queue.poll();
30            
31                if(checker(node[0]-1,node[1], grid) && !visited[node[0]-1][node[1]])
32                 helper(node[0]-1,node[1], grid, queue); //left
33                if(checker(node[0]-1,node[1]-1, grid) && !visited[node[0]-1][node[1]-1])
34                helper(node[0]-1,node[1]-1, grid, queue); // left-top
35                if(checker(node[0],node[1]-1, grid) && !visited[node[0]][node[1]-1])
36                helper(node[0],node[1]-1, grid, queue); //top
37                if(checker(node[0]+1,node[1]-1, grid) && !visited[node[0]+1][node[1]-1])
38                helper(node[0]+1,node[1]-1, grid, queue); //right-top
39                if(checker(node[0]+1,node[1], grid) && !visited[node[0]+1][node[1]])
40                helper(node[0]+1,node[1], grid, queue); //right
41                if(checker(node[0]+1,node[1]+1, grid) && !visited[node[0]+1][node[1]+1])
42                helper(node[0]+1,node[1]+1, grid, queue); //right-bottom
43                if(checker(node[0],node[1]+1, grid) && !visited[node[0]][node[1]+1])
44                helper(node[0],node[1]+1, grid, queue); //bottom
45                if(checker(node[0]-1,node[1]+1, grid) && !visited[node[0]-1][node[1]+1])
46                helper(node[0]-1,node[1]+1, grid, queue); //left-bottom
47
48                if(flag) return distance+1;
49            }
50
51            distance++;
52        }
53
54        return -1;
55    }
56
57    void helper(int i, int j, int[][] grid, Deque<int[]> queue) {
58
59        visited[i][j] = true;
60
61        if(i == grid.length -1 && j == grid.length -1) {
62            flag = true;
63            return;
64        }
65
66        queue.offer(new int[]{i,j});
67
68    }
69
70    boolean checker(int i, int j, int[][] grid) {
71        
72
73        if(i < 0 || i >= grid.length || j< 0 || j>= grid.length) return false;
74
75        if(grid[i][j] == 1) {
76            visited[i][j] = true;
77            return false;
78        }
79
80        return true;
81    }
82}