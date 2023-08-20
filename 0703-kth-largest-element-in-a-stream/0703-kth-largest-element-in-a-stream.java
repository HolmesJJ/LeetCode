class KthLargest {
    
    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int n) {
        if (q.size() < k) {
            q.add(n);
        } else if (q.peek() < n) {
            q.poll();
            q.add(n);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */