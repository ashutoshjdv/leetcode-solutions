// Last updated: 6/26/2026, 8:55:12 AM
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        if(n == 1) return heights[0];
        for(int i=0;i<=n;i++){

            int calcHeight = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && calcHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                // int width = i - stack.peek() -1;
                int width;

                if(stack.isEmpty()){
                    width = i;
                }
                else {
                    width = i - stack.peek() -1;
                }

                maxArea = Math.max(maxArea, height * width);

            }
            stack.push(i);
        }

        return maxArea;
    }
}