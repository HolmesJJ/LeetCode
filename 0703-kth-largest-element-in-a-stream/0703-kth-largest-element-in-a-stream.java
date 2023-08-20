class KthLargest {
    
    private List<Integer> list;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            this.list.add(nums[i]);
        }
        this.k = k - 1;
    }
    
    public int add(int val) {
        this.list.add(val);
        Collections.sort(this.list, Collections.reverseOrder());
        return this.list.get(this.k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */