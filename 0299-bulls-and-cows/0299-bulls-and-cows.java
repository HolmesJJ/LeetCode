class Solution {
    public String getHint(String secret, String guess) {
        char[] ss = secret.toCharArray();
        char[] gs = guess.toCharArray();
        int bulls = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == gs[i]) {
                bulls++;
            }
        }
        int cows = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != gs[i]) {
                map.put(ss[i], map.getOrDefault(ss[i], 0) + 1);
            }
        }
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != gs[i] && map.containsKey(gs[i]) && map.get(gs[i]) > 0) {
                map.put(gs[i], map.get(gs[i]) - 1);
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}