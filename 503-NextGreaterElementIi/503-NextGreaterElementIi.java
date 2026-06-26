// Last updated: 6/26/2026, 8:54:35 AM
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        for(int i=0; i<2*n;i++) {
            int current = i%n;
            while(!stack.isEmpty() && nums[current] > nums[stack.peek()]) {
                int indx = stack.pop();
                answer[indx] = nums[current];
            }
            if(i<n) stack.push(current);
        }

        return answer;

    }
}