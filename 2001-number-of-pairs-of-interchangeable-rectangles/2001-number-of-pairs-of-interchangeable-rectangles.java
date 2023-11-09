class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<>(); 
        for (int i = 0; i < rectangles.length; i++) {
            int w = rectangles[i][0];
            int h = rectangles[i][1];
            map.put(w * 1.0 / h, map.getOrDefault(w * 1.0 / h, 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            if (n > 1) {
                res += (long) n * (n - 1) / 2;
            }
        }
        return res;
    }
}