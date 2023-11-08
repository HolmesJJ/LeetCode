class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ts = text.toCharArray();
        for (int i = 0; i < ts.length; i++) {
            map.put(ts[i], map.getOrDefault(ts[i], 0) + 1);
        }
        int[] balloon = new int[5];
        balloon[0] = map.getOrDefault('b', 0);
        balloon[1] = map.getOrDefault('a', 0);
        balloon[2] = map.getOrDefault('l', 0) / 2;
        balloon[3] = map.getOrDefault('o', 0) / 2;
        balloon[4] = map.getOrDefault('n', 0);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < balloon.length; i++) {
            res = Math.min(res, balloon[i]);
        }
        return res;
    }
}