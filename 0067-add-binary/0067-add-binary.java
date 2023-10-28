class Solution {
    public String addBinary(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        String res = "";
        int carry = 0;
        int i = as.length - 1;
        int j = bs.length - 1;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? as[i] - '0' : 0;
            int digitB = j >= 0 ? bs[j] - '0' : 0;
            int total = digitA + digitB + carry;
            int sum = total % 2;
            res = sum + res;
            carry = total / 2;
            i--;
            j--;
        }
        if (carry > 0) {
            res = carry + res;
        }
        return res;
    }
}