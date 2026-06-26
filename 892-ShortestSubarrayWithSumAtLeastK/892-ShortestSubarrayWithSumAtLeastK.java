// Last updated: 6/26/2026, 8:54:23 AM
class Solution {
    public int shortestSubarray(int[] nums, int k) {

        if(nums.length == 0) return -1;
        int n = nums.length;

        long min_distance = Integer.MAX_VALUE;

        Deque<long[]> q = new ArrayDeque<>();

        long sum = 0;

         q.offerLast(new long[]{0,0});

        for(int i=0; i<n; i++) {
            sum+= nums[i];

            while(!q.isEmpty() && sum - q.peekFirst()[1] >= k) {

                min_distance = Math.min(min_distance, (i+1) - q.peekFirst()[0]);
                q.pollFirst();

            }

            while(!q.isEmpty() && sum <= q.peekLast()[1]) {
                q.pollLast();
            }

            q.offerLast(new long[]{i+1, sum});
        }

        if(min_distance == Integer.MAX_VALUE ) return -1;

        return (int)min_distance;
    }
}