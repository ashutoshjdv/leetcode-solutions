// Last updated: 6/26/2026, 8:54:43 AM
class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int count;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
        this.count = 0;
    }
    
    public void addNum(int num) {

        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        count++;
        
    }
    
    public double findMedian() {
        
        if(count%2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */