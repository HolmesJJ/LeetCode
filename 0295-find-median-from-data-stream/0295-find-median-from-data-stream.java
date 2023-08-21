class MedianFinder {
    
    private PriorityQueue<Integer> leftQ; // e.g., 4 3 2 1
    private PriorityQueue<Integer> rightQ; // e.g., 5 6 7 8
    private boolean isPopHalf = true;

    public MedianFinder() {
        leftQ = new PriorityQueue<>((a, b) -> (b - a));
        rightQ = new PriorityQueue<>((a, b) -> (a - b));
    }
    
    public void addNum(int num) {
        if (leftQ.size() == 0) {
            leftQ.add(num);
            return;
        }
        if (leftQ.size() == rightQ.size()) {
            if (rightQ.peek() < num) {
                int rightTop = rightQ.poll();
                rightQ.add(num);
                leftQ.add(rightTop);
            } else {
                leftQ.add(num);
            }
        } else {
            if (leftQ.peek() > num) {
                int leftTop = leftQ.poll();
                leftQ.add(num);
                rightQ.add(leftTop);
            } else {
                rightQ.add(num);
            }
        }
    }
    
    public double findMedian() {
        if (leftQ.size() == rightQ.size()) {
            return (leftQ.peek() + rightQ.peek()) / 2.0;
        } else {
            return leftQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */