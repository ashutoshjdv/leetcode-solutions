// Last updated: 6/26/2026, 8:54:39 AM
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>( (a,b) -> a[1] - b[1]);

        Map<Integer, Integer> map = new HashMap<>();

        int[] answer = new int[k];

        for(int i = 0; i< nums.length; i++) {
            
            map.compute(nums[i], (key, value) -> (value == null) ? 1 : value+1 );
        }

        for(int key : map.keySet()) {
            minHeap.offer(new Integer[]{ key, map.get(key) });

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int j=0;
        while(!minHeap.isEmpty()) {
            answer[j] = minHeap.poll()[0];
            j++;
        }

        return answer;
    }
}