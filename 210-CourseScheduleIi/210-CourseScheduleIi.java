// Last updated: 6/26/2026, 8:54:52 AM
class Solution {


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();

        int[] indegree = new int[numCourses];

        List<Integer> answer = new ArrayList<>(); 

        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for(int[] prereq : prerequisites) {
            int course = prereq[0];
            int preReq = prereq[1];

            adjList.get(preReq).add(course);
            indegree[course]++;
        }

        for(int i = 0; i< numCourses; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int index = queue.poll();
            answer.add(index);

            for(int neighbor : adjList.get(index)) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        if(answer.size() != numCourses) return new int[0];

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    //DFS Topological order solution


    boolean flag = false;


    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i< numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for(int[] prereq : prerequisites) {

            int course = prereq[0];
            int preReq = prereq[1];

            adjList.get(preReq).add(course);
        }

        int[] state = new int[numCourses];

        List<Integer> path = new ArrayList<>();

        for(int i =0; i < numCourses; i++) {

            if(state[i] == 0) {
                dfs(i, adjList, state, path);
                if(flag) return new int[0];
            }

        }

        Collections.reverse(path);
        return path.stream().mapToInt(Integer::intValue).toArray();
        
    }

    public void dfs(int i, List<List<Integer>> adjList, int[] state, List<Integer> path) {
        if(flag) return;

        if(state[i] == 1) {
            flag = true;
            return;
        }

        if(state[i] == 2) return;

        state[i] = 1;

        for(int neighbor : adjList.get(i)) {
            dfs(neighbor, adjList, state, path);
        }

        state[i] = 2;
        path.add(i);
    }
}