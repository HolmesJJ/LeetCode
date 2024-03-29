class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= max) {
                arr[i] = max;
            } else {
                int tmp = arr[i];
                arr[i] = max;
                max = tmp;
            }
        }
        return arr;
    }
}