class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> results = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < security.length; i++) {
                results.add(i);
            }
            return results;
        }
        int[] leftGoodDays = new int[security.length];
        int[] rightGoodDays = new int[security.length];
        for (int i = 1; i < security.length; i++) {
            if (security[i - 1] >= security[i]) {
                leftGoodDays[i] = leftGoodDays[i - 1] + 1;
            }
        }
        for (int i = security.length - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                rightGoodDays[i] = rightGoodDays[i + 1] + 1;
            }
        }
        for (int i = time; i < security.length - time; i++) {
            if (leftGoodDays[i] >= time && rightGoodDays[i] >= time) {
                results.add(i);
            }
        }
        return results;
    }
}