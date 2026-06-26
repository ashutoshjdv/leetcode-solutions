// Last updated: 6/26/2026, 8:54:27 AM
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0) return new int[0];
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        return answer;
    }
}