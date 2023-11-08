class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                i += 2;
                continue;
            }
            flowerbed[i] = 1;
            i++;
            n--;
            if (n == 0) {
                break;
            }
        }
        return n == 0;
    }
}