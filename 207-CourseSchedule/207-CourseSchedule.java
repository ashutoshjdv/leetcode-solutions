// Last updated: 6/26/2026, 8:54:55 AM
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i =0; i< numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for(int[] prereq : prerequisites) {
            int course = prereq[0];
            int preReq = prereq[1];

            adjList.get(preReq).add(course);
        }

        int[] visited = new int[numCourses];

        for(int i =0; i < numCourses; i++) {
            if(!dfs(i, adjList, visited)) return false;
        }

        return true;
    }

    public boolean dfs(int i, List<List<Integer>> adjList, int[] visited) {

        if(visited[i] == 1) return false;

        if(visited[i] == 2) return true;


        for(int neighbor : adjList.get(i)) {
            visited[i] = 1;
            if(!dfs(neighbor, adjList, visited)) return false;
            visited[i] = 2;
        }

        return true;
    }

}