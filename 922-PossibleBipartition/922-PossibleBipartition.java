// Last updated: 6/30/2026, 7:14:45 PM
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        Deque<Integer> queue = new ArrayDeque<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i< dislikes.length; i++) {
            map.computeIfAbsent(dislikes[i][0], k -> new ArrayList<>()).add(dislikes[i][1]);

            map.computeIfAbsent(dislikes[i][1], k -> new ArrayList<>()).add(dislikes[i][0]);
        }

        Map<Integer, Integer> mapLikes = new HashMap<>();


        for(int key : map.keySet()) {
            mapLikes.put(key, -1);
        }

        for(int key : map.keySet()) {

            if(mapLikes.get(key) != -1) continue;

            queue.offer(key);
            mapLikes.put(key, 0);

            while(!queue.isEmpty()) {

                int node = queue.poll();

                for(int neighbor : map.get(node)) {

                    if(mapLikes.get(node) == mapLikes.get(neighbor)) return false;

                    if(mapLikes.get(neighbor) == -1) {
                        queue.offer(neighbor);
                        mapLikes.put(neighbor, mapLikes.get(node) == 0 ? 1 : 0);
                    }
                }

            }
        }

        return true;

    }
}