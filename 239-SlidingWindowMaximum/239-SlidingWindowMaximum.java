// Last updated: 6/26/2026, 8:54:45 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] answer = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i =0; i<n; i++) {

            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                    dq.pollLast();
            }
            
            dq.offerLast(i);
            if(i+1 >= k) {
                answer[i-k+1] = nums[dq.peek()];
            }
        }
        return answer;
    }
}