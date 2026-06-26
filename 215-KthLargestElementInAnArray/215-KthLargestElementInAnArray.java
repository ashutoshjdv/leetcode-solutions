// Last updated: 6/26/2026, 8:54:51 AM
class Solution {
    public int findKthLargest(int[] nums, int k) {

        if(nums.length == 0 ) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i< nums.length; i++) {

            minHeap.offer(nums[i]);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}