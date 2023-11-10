class Solution {
    public String largestNumber(int[] nums) {
        Integer[] integerNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integerNums[i] = nums[i];
        }
        Arrays.sort(integerNums, (a, b) -> {
            String order1 = a + "" + b;
            String order2 = b + "" + a;
            return order2.compareTo(order1);
        });
        String res = "";
        if (integerNums[0] == 0) {
            return "0";
        }
        for (int num : integerNums) {
            res = res + num;
        }
        return res;
    }
}