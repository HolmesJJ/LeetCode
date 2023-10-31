class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> digits = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int digit = k % 10;
            k = k / 10;
            int total = num[i] + digit + carry;
            carry = total / 10;
            digits.add(total % 10);
        }
        while (k != 0 || carry != 0) {
            int digit = k % 10;
            k = k / 10;
            int total = digit + carry;
            carry = total / 10;
            digits.add(total % 10);
        }
        Collections.reverse(digits);
        return digits;
    }
}
