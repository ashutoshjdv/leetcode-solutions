// Last updated: 6/26/2026, 8:54:22 AM
class StockSpanner {

    Deque<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span =1;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            // pair.value() = pair.value() + stack.pop().value();
            span+= stack.pop()[1];
        }
        stack.push(new int[]{price,span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */